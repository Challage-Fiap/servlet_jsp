package servlet;
// ta dando erro no insert
// ver como arrumar

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Contas.Conta;
import Contas.ContaDAO;

@WebServlet("/adicionarConta")
public class AdicionarContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContaDAO contaDAO = new ContaDAO();
        try {
            List<Conta> contas = contaDAO.getAllContas();
            request.setAttribute("contas", contas);
            request.getRequestDispatcher("/listarContas.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContaDAO contaDAO = new ContaDAO();
        Conta conta = new Conta();

        conta.setNrConta(request.getParameter("nrConta"));
        conta.setTpConta(request.getParameter("tpConta"));
        conta.setSaldo(Double.parseDouble(request.getParameter("saldo")));
        conta.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));

        try {
            contaDAO.insertConta(conta);
            response.sendRedirect(request.getContextPath() + "/contas");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}