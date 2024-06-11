<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Transação</title>
</head>
<body>
    <h1>Adicionar Transação</h1>
    <form action="transacoes" method="post">
        ID da Transação: <input type="text" name="idTransacao"><br>
        Data (yyyy-mm-dd): <input type="text" name="data"><br>
        Valor: <input type="text" name="valor"><br>
        Número da Conta: <input type="text" name="contaNrConta"><br>
        <input type="submit" value="Adicionar">
    </form>
    <br>
    <form action="transacoes">
        <input type="submit" value="Voltar para Listagem de Transações">
    </form>
    <br>
	<a href="home.jsp">Voltar para Home</a>
</body>
</html>
