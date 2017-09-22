package br.edu.devmedia.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	
	protected static DatabaseConfig config;
	
	public static DatabaseConfig getInstance() {
		
		if(config == null) {
			
			config = new DatabaseConfig();
			
		}
		return config;
		
	}
	
	public Connection getConnection() throws SQLException {
		
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "mysql");
		
	}
	
	public static void main(String[] args) {
		
		try{
			
			System.out.println(DatabaseConfig.getInstance().getConnection() );
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
