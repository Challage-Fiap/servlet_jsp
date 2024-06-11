<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Transações</title>
</head>
<body>
    <h1>Listagem de Transações</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID da Transação</th>
                <th>Data</th>
                <th>Valor</th>
                <th>Número da Conta</th>
            </tr>
        </thead>
        <tbody>
            <% 
	            List<Transacao.Transacao> transacoes = (List<Transacao.Transacao>) request.getAttribute("transacoes");
	            for (Transacao.Transacao transacao : transacoes) { 
            %>
            <tr>
                <td><%= transacao.getIdTransacao() %></td>
                <td><%= transacao.getData() %></td>
                <td><%= transacao.getValor() %></td>
                <td><%= transacao.getContaNrConta() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <br>
    <form action="adicionarTransacao.jsp">
        <input type="submit" value="Adicionar Transação">
    </form>
</body>
</html>
