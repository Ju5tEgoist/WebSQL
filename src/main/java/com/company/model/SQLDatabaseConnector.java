package com.company.model;

import java.sql.Connection;

/**
 * Created by yulia on 15.05.17.
 */
public interface SQLDatabaseConnector {
    Connection connect(String database, String user, String password) ;

    Connection getConnection();
}
