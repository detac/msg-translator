package com.msg.translator;

import com.msg.translator.dao.DatabaseConnection;
import com.msg.translator.dao.DatabaseConnectionSQLite;
import com.msg.translator.dao.GlossaryDao;
import com.msg.translator.dao.PmkDao;
import com.msg.translator.service.GlossaryService;
import com.msg.translator.service.NonTranslatedTermsService;
import com.msg.translator.service.PmkService;
import com.msg.translator.service.TranslateService;

public class App {
	
	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();

		if (databaseConnection.isConnected()) {
			PmkDao pmkDao = new PmkDao(databaseConnection);

			GlossaryDao glossaryDao = new GlossaryDao();
			GlossaryService glossaryService = new GlossaryService(glossaryDao);
			TranslateService translateService = new TranslateService(glossaryService);

			NonTranslatedTermsService nonTranslatedTermsService = new NonTranslatedTermsService("src//main//resources//");

			PmkService pmkService = new PmkService(pmkDao, translateService, nonTranslatedTermsService);
			pmkService.translate(false, false);

			databaseConnection.close();
		}
	}
}
