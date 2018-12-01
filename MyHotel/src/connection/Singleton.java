package connection;

import java.sql.Connection;

public class Singleton {

	private Singleton() {
		
	}
	private static Connection instancia = null;
	public static Connection getInstancia() {
		if(instancia== null) {
			instancia = new Conexao().getConnection();
		}
		return instancia;
	}
}