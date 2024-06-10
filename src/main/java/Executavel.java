import java.sql.SQLException;
import java.util.Scanner;

import Cliente.Cliente;
import Cliente.ClienteDAO;
import Cliente.ClienteDAOTest;
import Contas.Conta;
import Contas.ContaDAO;
import Contas.ContaDAOTest;
import HistoricoCretido.HistCredito;
import HistoricoCretido.HistCreditoDAO;
import HistoricoCretido.HistCreditoDAOTest;
import RelatorioAnalises.RelatorioAnalises;
import RelatorioAnalises.RelatorioAnalisesDAO;
import RelatorioAnalises.RelatorioAnalisesDAOTest;
import Transacao.Transacao;
import Transacao.TransacaoDAO;
import Transacao.TransacaoDAOTest;

public class Executavel {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        // Inicializa o scanner nas classes de teste
        ClienteDAOTest.init(scanner);
        ContaDAOTest.init(scanner);
        HistCreditoDAOTest.init(scanner);
        RelatorioAnalisesDAOTest.init(scanner);
        TransacaoDAOTest.init(scanner); // Inicializa o scanner na classe TransacaoDAOTest

        // Testes de inserção
        ClienteDAOTest.testInsertCliente();
        ContaDAOTest.testInsertContas();
        HistCreditoDAOTest.testInsertHistCredito();
        RelatorioAnalisesDAOTest.testInsertRelatorioAnalise();
        TransacaoDAOTest.testInsertTransacao(); // Executa o teste de inserção de Transacao

        ClienteDAO clienteDAO = new ClienteDAO(); // classe de cliente
        ContaDAO contaDAO = new ContaDAO(); // classe de conta
        HistCreditoDAO histCreditoDAO = new HistCreditoDAO(); // classe de historico de credito
        RelatorioAnalisesDAO relatorioAnalisesDAO = new RelatorioAnalisesDAO(); // classe de relatorio de analises
        TransacaoDAO transacaoDAO = new TransacaoDAO(); // classe de transacao

        System.out.println("Get all de clientes"); // aqui ele vai fazer um loop ate ter todos os resultado de clientes
        try {
            for (Cliente cliente : clienteDAO.getAllClientes()) {
                System.out.println(cliente); // aqui ela joga no console os resultados
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fazer Get ALL de Clientes: " + e.getMessage()); // aqui e aonde vai ser minha exceção
        }

        System.out.println("Get all de Contas"); // aqui ele vai fazer um loop ate ter todos os resultado de Contas
        try {
            for (Conta conta : contaDAO.getAllContas()) {
                System.out.println(conta);  // aqui ela joga no console os resultados
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fazer Get ALL de Contas: " + e.getMessage());  // aqui e aonde vai ser minha exceção
        }
        
        System.out.println("Get all de Historico de credito"); // aqui ele vai fazer um loop ate ter todos os resultado de Historico de credito
        try {
            for (HistCredito histCredito : histCreditoDAO.getAllHistCredito()) {
                System.out.println(histCredito);  // aqui ela joga no console os resultados
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fazer Get ALL de Historico de credito: " + e.getMessage());  // aqui e aonde vai ser minha exceção
        }

        System.out.println("Get all de Relatórios de Análises"); // aqui ele vai fazer um loop ate ter todos os resultado de Relatórios de Análises
        try {
            for (RelatorioAnalises relatorioAnalise : relatorioAnalisesDAO.getAllRelatoriosAnalises()) {
                System.out.println(relatorioAnalise);  // aqui ela joga no console os resultados
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fazer Get ALL de Relatórios de Análises: " + e.getMessage());  // aqui e aonde vai ser minha exceção
        }

        System.out.println("Get all de Transações"); // aqui ele vai fazer um loop ate ter todos os resultado de Transações
        try {
            for (Transacao transacao : transacaoDAO.getAllTransacoes()) {
                System.out.println(transacao);  // aqui ela joga no console os resultados
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fazer Get ALL de Transações: " + e.getMessage());  // aqui e aonde vai ser minha exceção
        }

        scanner.close();
    }
}
