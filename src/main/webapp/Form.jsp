<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inserir Cliente</title>
</head>
<body>
    <h1>Inserir Novo Cliente</h1>
    <form action="InsertClienteServlet" method="post">
        <label for="idCliente">ID do Cliente:</label>
        <input type="number" id="idCliente" name="idCliente" required><br><br>

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br><br>

        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="infoContato">Informações de Contato:</label>
        <input type="text" id="infoContato" name="infoContato" required><br><br>

        <input type="submit" value="Inserir Cliente">
    </form>
</body>
</html>
