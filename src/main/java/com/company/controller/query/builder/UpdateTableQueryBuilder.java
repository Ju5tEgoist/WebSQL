package com.company.controller.query.builder;

import com.company.controller.query.executor.UpdateSqlQueryExecutor;
import com.company.model.InsertUpdateDeleteColumnDefinition;
import com.company.model.UpdateProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
