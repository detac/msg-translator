package com.msg.translator.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.msg.translator.model.PmkFormula;

public class PmkDaoTest {
	
	@Test
	public void getAll() {
		DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();
		if (databaseConnection.isConnected()) {
			PmkDao pmkDao = new PmkDao(databaseConnection);
			List<PmkFormula> result = pmkDao.getAll();
			databaseConnection.close();
			assertTrue(result.size() == 2);
		}
	}

	@Test
	public void store() {
		DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();
		if (databaseConnection.isConnected()) {
			PmkDao pmkDao = new PmkDao(databaseConnection);

			PmkFormula pmkFormula = new PmkFormula();
			pmkFormula.setObjectId("test1");
			pmkFormula.setDomainId("test2");
			pmkFormula.setFormulaTextWork("updated value");

			int result = pmkDao.store(pmkFormula, false);

			databaseConnection.close();
			assertTrue(result == 0);
		}
	}
}
