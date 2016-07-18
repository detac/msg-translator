package com.msg.translator;

import com.msg.translator.dao.DatabaseConnection;
import com.msg.translator.dao.DatabaseConnectionSQLite;
import com.msg.translator.dao.PmkDao;
import com.msg.translator.service.PmkService;
import com.msg.translator.service.TranslateService;

public class App {

  public static void main(String[] args) {
    DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();

    if (databaseConnection.isConnected()) {
      PmkDao pmkDao = new PmkDao(databaseConnection);
      TranslateService translateService = new TranslateService();

      PmkService pmkService = new PmkService(pmkDao, translateService);
      pmkService.translate();

      databaseConnection.close();
    }
  }
}
