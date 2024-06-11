<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Relatórios de Análises</title>
</head>
<body>
    <h1>Listagem de Relatórios de Análises</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID do Relatório de Análise</th>
                <th>Dados das Análises</th>
                <th>ID do Cliente</th>
            </tr>
        </thead>
        <tbody>
            <% 
	            List<RelatorioAnalises.RelatorioAnalises> relatoriosAnalises = (List<RelatorioAnalises.RelatorioAnalises>) request.getAttribute("relatoriosAnalises");
	            for (RelatorioAnalises.RelatorioAnalises relatorioAnalise : relatoriosAnalises) { 
            %>
            <tr>
                <td><%= relatorioAnalise.getIdRelatorioAnalise() %></td>
                <td><%= relatorioAnalise.getDadosAnalisesRelatorios() %></td>
                <td><%= relatorioAnalise.getIdCliente() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <br>
    <form action="adicionarRelatorioAnalise.jsp">
        <input type="submit" value="Adicionar Relatório de Análise">
    </form>
</body>
</html>
