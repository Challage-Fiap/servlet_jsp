package Contas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ContaDAOTest {
    private static Scanner scanner;

    public static void init(Scanner sc) {
        scanner = sc;
    }

    public static void testGetAllContas() {
        ContaDAO contaDAO = new ContaDAO();
        try {
            List<Conta> contas = contaDAO.getAllContas();
            if (contas != null && !contas.isEmpty()) {
                System.out.println("Contas encontradas:");
                for (Conta conta : contas) {
                    System.out.println("NrConta: " + conta.getNrConta() +
                            ", Tipo: " + conta.getTpConta() +
                            ", Saldo: " + conta.getSaldo() +
                            ", IdCliente: " + conta.getIdCliente());
                }
                System.out.println("Teste de getAllContas passou.");
            } else {
                System.out.println("Teste de getAllContas falhou: Nenhuma conta retornada.");
            }
        } catch (SQLException e) {
            System.out.println("Teste de getAllContas falhou: " + e.getMessage());
        }
    }

    public static void testInsertContas() {
        System.out.println("Você deseja inserir uma nova Conta? (sim/não)");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("sim")) {
            ContaDAO contaDAO = new ContaDAO();
            Conta conta = new Conta();

            System.out.println("Digite o número da conta:");
            String nrConta = scanner.nextLine();

            System.out.println("Digite o tipo da conta:");
            String tpConta = scanner.nextLine();

            System.out.println("Digite o saldo da conta:");
            double saldo = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o ID do cliente:");
            int idCliente = scanner.nextInt();
            scanner.nextLine();

            conta.setNrConta(nrConta);
            conta.setTpConta(tpConta);
            conta.setSaldo(saldo);
            conta.setIdCliente(idCliente);

            try {
                contaDAO.insertConta(conta);
                System.out.println("Conta inserida com sucesso.");
            } catch (SQLException e) {
                System.out.println("Falha ao inserir Conta: " + e.getMessage());
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }
}
