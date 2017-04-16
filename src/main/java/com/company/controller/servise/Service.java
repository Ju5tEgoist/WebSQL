package com.company.controller.servise;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yulia on 06.04.17.
 */
public interface Service {
    Map<String, String> getCommandsList();
    Set<String> getList() throws SQLException;
    void dropTable(String tableName) throws SQLException;
    void clearTable(String tableName) throws SQLException;
    void getCreateParameters() throws SQLException;
    void addName(String columnName);
    List<String> getColumnsName();

    int getCounter();

    void setColumnsNumber(String columnsNumber);
    int getColumnsNumber();
    void setCounter(int counter);
    void setTableName(String tName);
    String getTableName();
}
