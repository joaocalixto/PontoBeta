package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {

	public static Connection abrir() {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/";
		String db = "empregosonline";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + db, user, pass);
			System.out.println("Conexão aberta...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao abrir a conexão!!");
		}
		return con;
	}
	
	public static String verificarStatus(int i){
		
		if(i == 1){
			return "transação realizada com SUCESSO!";
			
		}
		else{
			return "ERRO na transação.";
		}
	}

}
