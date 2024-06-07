<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Contas.Conta" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Contas</title>
</head>
<body>
    <h1>Lista de Contas</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Número da Conta</th>
                <th>Tipo de Conta</th>
                <th>Saldo</th>
                <th>ID do Cliente</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Conta> contas = (List<Conta>) request.getAttribute("contas");
                if (contas != null) {
                    for (Conta conta : contas) {
            %>
                <tr>
                    <td><%= conta.getNrConta() %></td>
                    <td><%= conta.getTpConta() %></td>
                    <td><%= conta.getSaldo() %></td>
                    <td><%= conta.getIdCliente() %></td>
                </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <br>
    <a href="novaConta.jsp">Adicionar Nova Conta</a>
</body>
</html>
