<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Cliente.Cliente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
</head>
<body>
    <h1>Lista de Clientes</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Email</th>
                <th>Info Contato</th>
            </tr>
        </thead>
        <tbody>
            <% 
            // Precisa revisar ele nao esta trazendo as informações necessaria. Nenhum cliente encontrado.
            List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
            if (clientes != null && !clientes.isEmpty()) {
                for (Cliente cliente : clientes) { 
            %>
                    <tr>
                        <td><%= cliente.getIdCliente() %></td>
                        <td><%= cliente.getNome() %></td>
                        <td><%= cliente.getEndereco() %></td>
                        <td><%= cliente.getEmail() %></td>
                        <td><%= cliente.getInfoContato() %></td>
                    </tr>
            <% 
                } 
            } else { 
            %>
                <tr>
                    <td colspan="5">Nenhum cliente encontrado.</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
