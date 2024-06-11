package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import RelatorioAnalises.RelatorioAnalises;
import RelatorioAnalises.RelatorioAnalisesDAO;

@WebServlet("/relatoriosAnalises")
public class RelatoriosAnalisesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RelatorioAnalisesDAO relatoriosAnalisesDAO = new RelatorioAnalisesDAO();
        try {
            List<RelatorioAnalises> relatoriosAnalises = relatoriosAnalisesDAO.getAllRelatoriosAnalises();
            request.setAttribute("relatoriosAnalises", relatoriosAnalises);
            request.getRequestDispatcher("/listarRelatoriosAnalises.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RelatorioAnalisesDAO relatoriosAnalisesDAO = new RelatorioAnalisesDAO();
        RelatorioAnalises relatorioAnalise = new RelatorioAnalises();

        relatorioAnalise.setIdRelatorioAnalise(Integer.parseInt(request.getParameter("idRelatorioAnalise")));
        relatorioAnalise.setDadosAnalisesRelatorios(request.getParameter("dadosAnalisesRelatorios"));
        relatorioAnalise.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));

        try {
            relatoriosAnalisesDAO.insertRelatorioAnalise(relatorioAnalise);
            response.sendRedirect(request.getContextPath() + "/relatoriosAnalises");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
