package Transacao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TransacaoDAOTest {
    private static Scanner scanner;

    public static void init(Scanner sc) {
        scanner = sc;
    }

    public static void testGetAllTransacoes() {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        try {
            List<Transacao> transacoes = transacaoDAO.getAllTransacoes();
            if (transacoes != null && !transacoes.isEmpty()) {
                System.out.println("Transações encontradas:");
                for (Transacao transacao : transacoes) {
                    System.out.println(transacao);
                }
                System.out.println("Teste de getAllTransacoes passou.");
            } else {
                System.out.println("Teste de getAllTransacoes falhou: Nenhuma transação retornada.");
            }
        } catch (SQLException e) {
            System.out.println("Teste de getAllTransacoes falhou: " + e.getMessage());
        }
    }

    public static void testInsertTransacao() {
        System.out.println("Você deseja inserir uma nova Transação? (sim/não)");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("sim")) {
            TransacaoDAO transacaoDAO = new TransacaoDAO();
            Transacao transacao = new Transacao();

            System.out.println("Digite o ID da transação:");
            int idTransacao = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            System.out.println("Digite a data da transação (yyyy-mm-dd):");
            String dataStr = scanner.nextLine();
            Date data = Date.valueOf(dataStr);

            System.out.println("Digite o valor da transação:");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // consume the remaining newline

            System.out.println("Digite o número da conta:");
            String contaNrConta = scanner.nextLine();

            transacao.setIdTransacao(idTransacao);
            transacao.setData(data);
            transacao.setValor(valor);
            transacao.setContaNrConta(contaNrConta);

            try {
                transacaoDAO.insertTransacao(transacao);
                System.out.println("Transação inserida com sucesso.");
            } catch (SQLException e) {
                System.out.println("Falha ao inserir transação: " + e.getMessage());
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init(scanner);

        System.out.println("Escolha a operação a ser realizada:");
        System.out.println("1. Listar todas as transações");
        System.out.println("2. Inserir uma nova transação");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

        switch (opcao) {
            case 1:
                testGetAllTransacoes();
                break;
            case 2:
                testInsertTransacao();
                break;
            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
