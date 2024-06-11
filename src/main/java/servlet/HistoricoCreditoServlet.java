package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import HistoricoCretido.HistCredito;
import HistoricoCretido.HistCreditoDAO;

@WebServlet("/historicoCredito")
public class HistoricoCreditoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HistCreditoDAO histCreditoDAO = new HistCreditoDAO();
        try {
            List<HistCredito> historicos = histCreditoDAO.getAllHistCredito();
            request.setAttribute("historicos", historicos);
            request.getRequestDispatcher("/listarHistoricoCredito.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HistCreditoDAO histCreditoDAO = new HistCreditoDAO();
        HistCredito histCredito = new HistCredito();

        histCredito.setIdHistCredito(Integer.parseInt(request.getParameter("idHistCredito")));
        histCredito.setDadosRelacionados(request.getParameter("dadosRelacionados"));
        histCredito.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));

        try {
            histCreditoDAO.insertHistCredito(histCredito);
            response.sendRedirect(request.getContextPath() + "/historicoCredito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
