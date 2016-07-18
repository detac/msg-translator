package com.msg.translator.dao;

import java.sql.Connection;

public interface DatabaseConnection {

  public boolean isConnected();

  public Connection getConnection();

  public boolean close();
}
