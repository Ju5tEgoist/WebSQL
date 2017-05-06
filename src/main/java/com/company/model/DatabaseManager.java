package com.company.model;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yulia on 28.09.16.
 */

@Component
public class DatabaseManager {
    public static Connection connection;
    private static Statement stmt;

    public static Connection connect(String database, String user, String password) throws SQLException {
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

        stmt = connection.createStatement();
        return connection;
    }

    public Statement getStatement(){
        return stmt;
    }

    public static Connection getConnection()  {
        return connection;
    }
}
