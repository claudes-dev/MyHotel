package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhot:3306/dbmyhotel";
	private final String user = "root";
	private final String password = "123456";

	public Connection getConnection() {

		Connection conexao = null;
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);

		} catch (SQLException exe) {
			System.out.println("Sua conexão foi mal sucedida");
		} catch (ClassNotFoundException excecao) {
			System.out.println("Drive não encontrado");
		}
		return conexao;
	}

	public void closeConnection(Connection conexao) {
		try {
			if(!conexao.isClosed()) {
				conexao.close();
			}
		}catch(SQLException exe){
			System.out.println("Conexão nao foi fechada"+ exe.getMessage());
			}
	}

}
