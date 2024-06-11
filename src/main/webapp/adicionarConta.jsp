<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Conta</title>
</head>
<body>
    <h1>Adicionar Conta</h1>
    <form action="adicionarConta" method="post">
        Número da Conta: <input type="text" name="nrConta"><br>
        Tipo de Conta: <input type="text" name="tpConta"><br>
        Saldo: <input type="text" name="saldo"><br>
        ID do Cliente: <input type="text" name="idCliente"><br>
        <input type="submit" value="Adicionar">
    </form>
</body>
</html>
