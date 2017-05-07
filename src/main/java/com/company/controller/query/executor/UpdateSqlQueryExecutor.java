package com.company.controller.query.executor;

import com.company.model.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class UpdateSqlQueryExecutor {

    @Autowired
   DatabaseManager databaseManager;

    public void execute(String query) throws SQLException {
        databaseManager.getStatement().executeUpdate(query);
    }
}
