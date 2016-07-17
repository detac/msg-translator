package com.msg.translator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSQLite implements DatabaseConnection {

	public static final String DATABASE_DRIVER = "SQLite.JDBCDriver";
	public static final String DB_URL = "jdbc:sqlite:/msgtranslate";
	public static final String USER = "goca";
	public static final String PASS = "goca";

	public boolean connected = true;

	public Connection connection;

	public DatabaseConnectionSQLite() {
		try {
			Class.forName(DATABASE_DRIVER);
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DatabaseConnectionSQLite : " + e);
			connected = false;
		}
	}

	@Override
	public Connection getConnection() {
		return connection;	
	}

	public boolean isConnected() {
		return connected;
	}

	public boolean close() {
		try {
			if (connected && !connection.isClosed()) {
				connection.close();
			}
			return true;
		} catch (SQLException e) {
			System.out.println("DatabaseConnectionSQLite.close() : " + e);
			return false;
		}
	}
}
