package com.company.controller.query.builder;

import com.company.model.DatabaseManager;
import java.sql.SQLException;

/**
 * Created by yulia on 23.02.17.
 */
public class DeleteTableQueryBuilder {

    public void build(String tableName, String columnName, String value) throws SQLException {
        String sql = "DELETE FROM " + tableName + " " + "WHERE" + " " + columnName + " " + "=" + " " + "'" + value + "'";
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.getStatement().executeUpdate(sql);
    }
}
