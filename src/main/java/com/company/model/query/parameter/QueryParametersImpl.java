package com.company.model.query.parameter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class QueryParametersImpl implements QueryParameters {

    public QueryParametersImpl() {}

    private List<String> columnsName = new ArrayList<>();
    private int columnsNumber;
    private String tableName;
    private int i = 1;
    private String column;
    private String oldValue;
    private String newValue;
    private String value;
    private String database;
    private String userName;
    private String password ;

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public List<String> getInsertValues() {
        return insertValues;
    }

    private List<String> insertValues = new ArrayList<>();
    @Override
    public void addValue(String value) {insertValues.add("'" + value + "'");}
    @Override
    public String getValue() {
        return value;
    }
    @Override
    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String getDatabase() {
        return database;
    }

    public QueryParametersImpl(int columnsNumber, String tableName, int i, String column, String oldValue, String newValue, String value, String database, String userName, String password) {
        this.value = value;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.columnsNumber = columnsNumber;
        this.tableName = tableName;
        this.i = i;
        this.column = column;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
    @Override
    public String getColumn() {
        return column;
    }

    @Override
    public String getOldValue() {
        return oldValue;
    }
    @Override
    public String getNewValue() {
        return newValue;
    }
    @Override
    public void addName(String columnName) {
        columnsName.add(columnName);
    }
    @Override
    public List<String> getColumnsName() {
        return columnsName;
    }
    @Override
    public int getCounter() {
        return i++;
    }
    @Override
    public void setColumnsNumber(String columnsNumber) {
        this.columnsNumber = Integer.parseInt(columnsNumber);
    }
    @Override
    public int getColumnsNumber() {
        return columnsNumber;
    }
    @Override
    public void setCounter(int counter) {
        this.i = counter;
    }
    @Override
    public void setTableName(String tName) {
        this.tableName = tName;
    }
    @Override
    public String getTableName() {
        return tableName;
    }
    @Override
    public void setColumn(String column) {
        this.column = column;
    }
    @Override
    public void setOldValue(String oldValue) {
        this.oldValue = "'" + oldValue + "'";
    }
    @Override
    public void setNewValue(String newValue) {
        this.newValue = "'" + newValue + "'" ;
    }
}
