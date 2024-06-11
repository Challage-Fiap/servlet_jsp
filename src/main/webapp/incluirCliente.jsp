<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Incluir Cliente</title>
</head>
<body>
    <h1>Incluir Cliente</h1>
    <form action="cliente" method="post">
        <label for="idCliente">ID:</label>
        <input type="text" id="idCliente" name="idCliente"><br><br>
        
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome"><br><br>
        
        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco"><br><br>
        
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br><br>
        
        <label for="infoContato">Informações de Contato:</label>
        <input type="text" id="infoContato" name="infoContato"><br><br>
        
        <input type="submit" value="Incluir">
    </form>
    <br>
	<a href="home.jsp">Voltar para Home</a>
</body>
</html>
