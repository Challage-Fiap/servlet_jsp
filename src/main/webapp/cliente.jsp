<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Clientes</title>
</head>
<body>
    <h1>Clientes</h1>
    <a href="incluirCliente.jsp">Incluir Novo Cliente</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Email</th>
                <th>Informações de Contato</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Cliente.Cliente> clientes = (List<Cliente.Cliente>)request.getAttribute("clientes");
                for (Cliente.Cliente cliente : clientes) { 
            %>
            <tr>
                <td><%= cliente.getIdCliente() %></td>
                <td><%= cliente.getNome() %></td>
                <td><%= cliente.getEndereco() %></td>
                <td><%= cliente.getEmail() %></td>
                <td><%= cliente.getInfoContato() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
