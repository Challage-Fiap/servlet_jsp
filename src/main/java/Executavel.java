import java.sql.SQLException;

import Cliente.Cliente;
import Cliente.ClienteDAO;
import Cliente.ClienteDAOTest;

public class Executavel {
	 public static void main(String[] args) throws SQLException {
		ClienteDAOTest.testInsertCliente();
		 
		 ClienteDAO clienteDAO = new ClienteDAO();
		 
		 System.out.println("Get all de clientes");
		 try {
			 for (Cliente cliente : clienteDAO.getAllClientes()) {
				 System.out.println(cliente);
			 }
		 } catch (SQLException e) {
			 System.err.println("Erro ao fazer Get ALL Clientes" + e.getMessage());
		 }
	 }
}
