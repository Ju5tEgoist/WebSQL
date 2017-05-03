package com.company.controller.query.builder;

import com.company.controller.query.executor.UpdateSqlQueryExecutor;

import java.sql.SQLException;

/**
 * Created by yulia on 23.02.17.
 */
public class UpdateTableQueryBuilder {

    public void build(String tableName, String column, String newValue, String oldValue) throws SQLException {
        String sql = "UPDATE " + tableName + " " + "SET" + " " + column + " " + "=" + " "
                + newValue + " " + "WHERE" + " " + column + " " + "=" + oldValue ;
        new UpdateSqlQueryExecutor().execute(sql);
    }
}
