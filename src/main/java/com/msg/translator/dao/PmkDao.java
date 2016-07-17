package com.msg.translator.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.msg.translator.model.PmkFormula;

public class PmkDao {

	private static final String LIST_ALL_SQL = "SELECT OBJECTID, DOMAINID, FORMULATEXTWORK FROM PMKFORMULA";
	private static final String STORE_SQL = "UPDATE PMKFORMULA SET FORMULATEXTWORK = ? WHERE OBJECTID = ? AND DOMAINID = ?"; // poslao
																																// zadatak.

	private DatabaseConnection databaseConnection;

	public PmkDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	@SuppressWarnings("unused")
	private PmkDao() {
	}

	public List<PmkFormula> getAll() {
		List<PmkFormula> result = new ArrayList<>();

		try (Statement statement = databaseConnection.getConnection().createStatement()) {

			ResultSet rs = statement.executeQuery(LIST_ALL_SQL);
			while (rs.next()) {
				PmkFormula pmkFormula = new PmkFormula();
				pmkFormula.setObjectId(rs.getString(1));
				pmkFormula.setDomainId(rs.getString(2));
				pmkFormula.setFormulaTextWork(rs.getString(3));
				result.add(pmkFormula);
			}

		} catch (SQLException e) {
			System.out.println("PmkDao.getAll(): " + e);
		}

		return result;
	}

	public int store(PmkFormula formula) {
		try {
			PreparedStatement ps = databaseConnection.getConnection().prepareStatement(STORE_SQL);
			ps.setString(1, formula.getFormulaTextWork());
			ps.setString(2, formula.getObjectId());
			ps.setString(3, formula.getDomainId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PmkDao.store(): " + e);
		}
		return -1;
	}
}
