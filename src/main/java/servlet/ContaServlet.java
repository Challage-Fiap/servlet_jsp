package servlet;

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

@WebServlet("/contas")
public class ContaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContaDAO contaDAO = new ContaDAO();
        try {
            List<Conta> contas = contaDAO.getAllContas();
            request.setAttribute("contas", contas);
            request.getRequestDispatcher("contas.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erro ao obter contas", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nrConta = request.getParameter("nrConta");
        String tpConta = request.getParameter("tpConta");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        Conta conta = new Conta();
        conta.setNrConta(nrConta);
        conta.setTpConta(tpConta);
        conta.setSaldo(saldo);
        conta.setIdCliente(idCliente);

        ContaDAO contaDAO = new ContaDAO();
        try {
            contaDAO.insertConta(conta);
        } catch (SQLException e) {
            throw new ServletException("Erro ao inserir conta", e);
        }

        response.sendRedirect("contas");
    }
}
