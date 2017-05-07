package com.company.controller.service;

import org.springframework.stereotype.Component;

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
    void addName(String columnName);
    void addValue(String value);
    List<String> getColumnsName();
    List getInsertColumnsName(String tableName) throws SQLException;
    int getCounter();
    void insertData() throws SQLException;
    void setColumnsNumber(String columnsNumber);
    int getColumnsNumber();
    void setCounter(int counter);
    void setTableName(String tName);
    String getTableName();

    int getInsertColumnsNumber() throws SQLException;

    void setColumn(String column);

    void setOldValue(String oldValue);

    void setNewValue(String newValue);

    void updateTable() throws SQLException;
}
