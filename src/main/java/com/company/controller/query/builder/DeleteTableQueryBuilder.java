package com.company.controller.query.builder;


import java.sql.SQLException;

/**
 * Created by yulia on 23.02.17.
 */
public class DeleteTableQueryBuilder {
    private String tableName;
    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String build(String columnName, String value) throws SQLException {
        String sql = "DELETE FROM " + tableName + " " + "WHERE" + " " + columnName + " " + "=" + " " + "'" + value + "'";
        return sql;
    }
}
