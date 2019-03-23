package com.techfun.jdbc.connectionhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/Ride";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "admin";
	
	public static Connection getDBConnection() {
		Connection dbConnection = null;
		
		try {
			Class.forName(DB_DRIVER);	
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return dbConnection;
	}
}
