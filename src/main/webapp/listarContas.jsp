<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page session="false" %>
<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("error.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Contas</title>
</head>
<body>
    <h1>Listagem de Contas</h1>
    <a href="adicionarConta.jsp">Incluir Novo Cliente</a>
    <table border="1">
        <thead>
            <tr>
                <th>Número da Conta</th>
                <th>Tipo de Conta</th>
                <th>Saldo</th>
                <th>ID do Cliente</th>
            </tr>
        </thead>
        <tbody>
		    <% 
		    List<Contas.Conta> contas = (List<Contas.Conta>) request.getAttribute("contas");
		    if (contas != null) {
		        for (Contas.Conta conta : contas) { 
		    %>
		    <tr>
		        <td><%= conta.getNrConta() %></td>
		        <td><%= conta.getTpConta() %></td>
		        <td><%= conta.getSaldo() %></td>
		        <td><%= conta.getIdCliente() %></td>
		    </tr>
		    <% 
		        }
		    } else { 
		    %>
		    <tr>
		        <td colspan="4">Nenhuma conta encontrada</td>
		    </tr>
		    <% } %>
		</tbody>
    </table>
    <br>
	<a href="home.jsp">Voltar para Home</a>
</body>
</html>
