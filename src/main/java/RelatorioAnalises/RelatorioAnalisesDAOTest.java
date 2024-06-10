package RelatorioAnalises;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class RelatorioAnalisesDAOTest {
    private static Scanner scanner;

    public static void init(Scanner sc) {
        scanner = sc;
    }

    public static void testGetAllRelatoriosAnalises() {
        RelatorioAnalisesDAO relatoriosAnalisesDAO = new RelatorioAnalisesDAO();
        try {
            List<RelatorioAnalises> relatoriosAnalises = relatoriosAnalisesDAO.getAllRelatoriosAnalises();
            if (relatoriosAnalises != null && !relatoriosAnalises.isEmpty()) {
                System.out.println("Relatórios de Análises encontrados:");
                for (RelatorioAnalises relatorioAnalise : relatoriosAnalises) {
                    System.out.println(relatorioAnalise);
                }
                System.out.println("Teste de getAllRelatoriosAnalises passou.");
            } else {
                System.out.println("Teste de getAllRelatoriosAnalises falhou: Nenhum relatório de análise retornado.");
            }
        } catch (SQLException e) {
            System.out.println("Teste de getAllRelatoriosAnalises falhou: " + e.getMessage());
        }
    }

    public static void testInsertRelatorioAnalise() {
        System.out.println("Você deseja inserir um novo Relatório de Análise? (sim/não)");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("sim")) {
            RelatorioAnalisesDAO relatoriosAnalisesDAO = new RelatorioAnalisesDAO();
            RelatorioAnalises relatorioAnalise = new RelatorioAnalises();

            System.out.println("Digite o ID do relatório de análise:");
            int idRelatorioAnalise = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            System.out.println("Digite os dados do relatório de análise:");
            String dadosAnalisesRelatorios = scanner.nextLine();

            System.out.println("Digite o ID do cliente:");
            int idCliente = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            relatorioAnalise.setIdRelatorioAnalise(idRelatorioAnalise);
            relatorioAnalise.setDadosAnalisesRelatorios(dadosAnalisesRelatorios);
            relatorioAnalise.setIdCliente(idCliente);

            try {
                relatoriosAnalisesDAO.insertRelatorioAnalise(relatorioAnalise);
                System.out.println("Relatório de análise inserido com sucesso.");
            } catch (SQLException e) {
                System.out.println("Falha ao inserir relatório de análise: " + e.getMessage());
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init(scanner);

        System.out.println("Escolha a operação a ser realizada:");
        System.out.println("1. Listar todos os relatórios de análise");
        System.out.println("2. Inserir um novo relatório de análise");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

        switch (opcao) {
            case 1:
                testGetAllRelatoriosAnalises();
                break;
            case 2:
                testInsertRelatorioAnalise();
                break;
            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
