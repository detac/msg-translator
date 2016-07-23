package com.msg.translator.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DatabaseConnectionTest {
	
	@Test
	public void databaseConnectionSQLite() {
		DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();
		assertTrue(databaseConnection.isConnected());
		assertTrue(databaseConnection.close());
	}
}
