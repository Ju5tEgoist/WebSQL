package com.company.model;

import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by yulia on 28.09.16.
 */

@Component
public class PostgresSQLDatabaseConnector implements SQLDatabaseConnector {
    private Connection connection;

    @Override
    public Connection connect(String database, String user, String password)  {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Please add jdbc jar to project.", e);
            }
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/" + database, user,
                        password);
            } catch (SQLException e) {
                throw new RuntimeException(
                        String.format("Can't get connection for model:%s user:%s",
                                database, user),
                        e);

            }

        return connection;
    }

    @Override
     public Connection getConnection()  {
        return connection;
    }
}
