package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String url = "jdbc:mysql://localhost:3306/Login";
	private static final String user = "root";
	private static final String password = "Lvc1998$";
	
	public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
	}
}
