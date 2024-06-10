package HistoricoCretido;

import java.sql.SQLException;
import java.util.Scanner;

public class HistCreditoDAOTest {
    private static Scanner scanner;

    public static void init(Scanner sc) {
        scanner = sc;
    }

    public static void testInsertHistCredito() {
        System.out.println("Você deseja inserir um novo histórico de crédito? (sim/não)");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("sim")) {
            HistCreditoDAO histCreditoDAO = new HistCreditoDAO();
            HistCredito histCredito = new HistCredito();

            System.out.println("Digite o ID do histórico de crédito:");
            int idHistCredito = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite os dados relacionados:");
            String dadosRelacionados = scanner.nextLine();

            System.out.println("Digite o ID do cliente:");
            int idCliente = scanner.nextInt();
            scanner.nextLine();

            histCredito.setIdHistCredito(idHistCredito);
            histCredito.setDadosRelacionados(dadosRelacionados);
            histCredito.setIdCliente(idCliente);

            try {
                histCreditoDAO.insertHistCredito(histCredito);
                System.out.println("Histórico de crédito inserido com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao inserir histórico de crédito: " + e.getMessage());
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }
}
