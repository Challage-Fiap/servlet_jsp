<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Histórico de Crédito</title>
</head>
<body>
    <h1>Listagem de Histórico de Crédito</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID do Histórico de Crédito</th>
                <th>Dados Relacionados</th>
                <th>ID do Cliente</th>
            </tr>
        </thead>
        <tbody>
            <% 
	            List<HistoricoCretido.HistCredito> historicos = (List<HistoricoCretido.HistCredito>) request.getAttribute("historicos");
	            for (HistoricoCretido.HistCredito histCredito : historicos) { 
            %>
            <tr>
                <td><%= histCredito.getIdHistCredito() %></td>
                <td><%= histCredito.getDadosRelacionados() %></td>
                <td><%= histCredito.getIdCliente() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <br>
    <form action="adicionarHistoricoCredito.jsp">
        <input type="submit" value="Adicionar Histórico de Crédito">
    </form>
</body>
</html>