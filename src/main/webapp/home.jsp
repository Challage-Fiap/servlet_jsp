<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>Página Inicial</title>
</head>
<body>
    <h1>Bem-vindo ao Sistema de Gestão</h1>
    <ul>
        <li><a href="cliente">Clientes</a></li>
        <li><a href="adicionarConta">Contas</a></li>
        <li><a href="historicoCredito">Histórico de Crédito</a></li>
        <li><a href="relatoriosAnalises">Relatórios de Análises</a></li>
        <li><a href="transacoes">Transações</a></li>
    </ul>
    <br>
</body>
</html>
