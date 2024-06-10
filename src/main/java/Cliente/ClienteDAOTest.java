package Cliente;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClienteDAOTest {
    private static Scanner scanner;

    public static void init(Scanner sc) {
        scanner = sc;
    }

    public static void testGetAllClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            List<Cliente> clientes = clienteDAO.getAllClientes();
            if (clientes != null && !clientes.isEmpty()) {
                System.out.println("Clientes encontrados:");
                for (Cliente cliente : clientes) {
                    System.out.println("ID: " + cliente.getIdCliente() +
                            ", Nome: " + cliente.getNome() +
                            ", Endereço: " + cliente.getEndereco() +
                            ", Email: " + cliente.getEmail() +
                            ", Info Contato: " + cliente.getInfoContato());
                }
                System.out.println("Teste de getAllClientes passou.");
            } else {
                System.out.println("Teste de getAllClientes falhou: Nenhum cliente retornado.");
            }
        } catch (SQLException e) {
            System.out.println("Teste de getAllClientes falhou: " + e.getMessage());
        }
    }

    public static void testInsertCliente() {
        System.out.println("Você deseja inserir um novo cliente? (sim/não)");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("sim")) {
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = new Cliente();

            System.out.println("Digite o ID do cliente:");
            int idCliente = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o nome do cliente:");
            String nome = scanner.nextLine();

            System.out.println("Digite o endereço do cliente:");
            String endereco = scanner.nextLine();

            System.out.println("Digite o email do cliente:");
            String email = scanner.nextLine();

            System.out.println("Digite as informações de contato do cliente:");
            String infoContato = scanner.nextLine();

            cliente.setIdCliente(idCliente);
            cliente.setNome(nome);
            cliente.setEndereco(endereco);
            cliente.setEmail(email);
            cliente.setInfoContato(infoContato);

            try {
                clienteDAO.insertCliente(cliente);
                System.out.println("Cliente inserido com sucesso.");
            } catch (SQLException e) {
                System.out.println("Falha ao inserir cliente: " + e.getMessage());
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }
}
