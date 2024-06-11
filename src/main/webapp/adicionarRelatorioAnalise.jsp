<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Relatório de Análise</title>
</head>
<body>
    <h1>Adicionar Relatório de Análise</h1>
    <form action="relatoriosAnalises" method="post">
        ID do Relatório de Análise: <input type="text" name="idRelatorioAnalise"><br>
        Dados das Análises: <input type="text" name="dadosAnalisesRelatorios"><br>
        ID do Cliente: <input type="text" name="idCliente"><br>
        <input type="submit" value="Adicionar">
    </form>
    <br>
    <form action="relatoriosAnalises">
        <input type="submit" value="Voltar para Listagem de Relatórios de Análises">
    </form>
</body>
</html>
