package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Cliente.Cliente;
import Cliente.ClienteDAO;

@WebServlet("/InsertClienteServlet")
public class InsertClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Recebendo requisição para inserir cliente");

        String idClienteString = request.getParameter("idCliente");
        System.out.println("ID do Cliente recebido: " + idClienteString);

        if (idClienteString != null && !idClienteString.isEmpty()) {
            try {
                int idCliente = Integer.parseInt(idClienteString);

                String nome = request.getParameter("nome");
                String endereco = request.getParameter("endereco");
                String email = request.getParameter("email");
                String infoContato = request.getParameter("infoContato");

                System.out.println("Nome: " + nome);
                System.out.println("Endereço: " + endereco);
                System.out.println("Email: " + email);
                System.out.println("Info Contato: " + infoContato);

                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setEmail(email);
                cliente.setInfoContato(infoContato);

                ClienteDAO clienteDAO = new ClienteDAO();
                try {
                    clienteDAO.insertCliente(cliente);

                    List<Cliente> clientes = clienteDAO.getAllClientes();

                    request.setAttribute("clientes", clientes);

                    request.getRequestDispatcher("listaClientes.jsp").forward(request, response);
                } catch (SQLException e) {
                    response.getWriter().println("Falha ao inserir cliente: " + e.getMessage());
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("ID do cliente inválido.");
            }
        } else {
            response.getWriter().println("ID do cliente é nulo ou vazio.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
