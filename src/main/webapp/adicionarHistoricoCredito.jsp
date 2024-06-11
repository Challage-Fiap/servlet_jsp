<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Histórico de Crédito</title>
</head>
<body>
    <h1>Adicionar Histórico de Crédito</h1>
    <form action="historicoCredito" method="post">
        ID do Histórico de Crédito: <input type="text" name="idHistCredito"><br>
        Dados Relacionados: <input type="text" name="dadosRelacionados"><br>
        ID do Cliente: <input type="text" name="idCliente"><br>
        <input type="submit" value="Adicionar">
    </form>
    <br>
    <form action="historicoCredito">
        <input type="submit" value="Voltar para Listagem de Histórico de Crédito">
    </form>
    <br>
	<a href="home.jsp">Voltar para Home</a>
</body>
</html>
