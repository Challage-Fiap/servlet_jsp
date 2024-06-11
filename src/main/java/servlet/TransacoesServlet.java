package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Transacao.Transacao;
import Transacao.TransacaoDAO;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        try {
            List<Transacao> transacoes = transacaoDAO.getAllTransacoes();
            request.setAttribute("transacoes", transacoes);
            request.getRequestDispatcher("/listarTransacoes.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Transacao transacao = new Transacao();

        transacao.setIdTransacao(Integer.parseInt(request.getParameter("idTransacao")));
        transacao.setData(Date.valueOf(request.getParameter("data")));
        transacao.setValor(Double.parseDouble(request.getParameter("valor")));
        transacao.setContaNrConta(request.getParameter("contaNrConta"));

        try {
            transacaoDAO.insertTransacao(transacao);
            response.sendRedirect(request.getContextPath() + "/transacoes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}