package com.company.controller.query.executor;

import com.company.model.SQLDatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class UpdateSqlQueryExecutor {

    @Autowired
    SQLDatabaseConnector sqlDatabaseConnector;

    public void execute(String query) throws SQLException {
        sqlDatabaseConnector.getConnection().createStatement().executeUpdate(query);
    }
}
