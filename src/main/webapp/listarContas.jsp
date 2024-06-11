<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
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
            for (Contas.Conta conta : contas) { 
            %>
            <tr>
                <td><%= conta.getNrConta() %></td>
                <td><%= conta.getTpConta() %></td>
                <td><%= conta.getSaldo() %></td>
                <td><%= conta.getIdCliente() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <br>
	<a href="home.jsp">Voltar para Home</a>
</body>
</html>
