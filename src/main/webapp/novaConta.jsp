<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nova Conta</title>
</head>
<body>
    <h1>Adicionar Nova Conta</h1>
    <form action="contas" method="post">
        <label for="nrConta">Número da Conta:</label>
        <input type="text" id="nrConta" name="nrConta" required><br>

        <label for="tpConta">Tipo de Conta:</label>
        <input type="text" id="tpConta" name="tpConta" required><br>

        <label for="saldo">Saldo:</label>
        <input type="number" step="0.01" id="saldo" name="saldo" required><br>

        <label for="idCliente">ID do Cliente:</label>
        <input type="number" id="idCliente" name="idCliente" required><br>

        <input type="submit" value="Adicionar">
    </form>
    <br>
    <a href="contas">Voltar para a Lista de Contas</a>
</body>
</html>