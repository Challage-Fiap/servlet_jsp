package servlet;

import Cliente.Cliente;
import Cliente.ClienteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable; // Import adicionado
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        clienteDAO = new ClienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Cliente> clientes = clienteDAO.getAllClientes();
            request.setAttribute("clientes", clientes);
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String infoContato = request.getParameter("infoContato");

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setEmail(email);
        cliente.setInfoContato(infoContato);

        try {
            clienteDAO.insertCliente(cliente);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        response.sendRedirect("cliente");
    }
}
