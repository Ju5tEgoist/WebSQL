package com.company.controller.query.parameter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class QueryParameters {

    public QueryParameters() {
    }

    private List<String> columnsName;
    private int columnsNumber;
    private String tableName;
    private int i = 1;
    private String column;
    private String oldValue;
    private String newValue;
    private String value;

    public List<String> getInsertValues() {
        return insertValues;
    }

    private List<String> insertValues = new ArrayList<>();

    public void addValue(String value) {insertValues.add("'" + value + "'");}
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public QueryParameters(int columnsNumber, String tableName, int i, String column, String oldValue, String newValue, String value) {
        this.value = value;
        this.columnsName = new ArrayList<>();
        this.columnsNumber = columnsNumber;
        this.tableName = tableName;
        this.i = i;
        this.column = column;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getColumn() {
        return column;
    }


    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void addName(String columnName) {
        columnsName.add(columnName);
    }

    public List<String> getColumnsName() {
        return columnsName;
    }

    public int getCounter() {
        return i++;
    }

    public void setColumnsNumber(String columnsNumber) {
        this.columnsNumber = Integer.parseInt(columnsNumber);
    }

    public int getColumnsNumber() {
        return columnsNumber;
    }

    public void setCounter(int counter) {
        this.i = counter;
    }

    public void setTableName(String tName) {
        this.tableName = tName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = "'" + oldValue + "'";
    }

    public void setNewValue(String newValue) {
        this.newValue = "'" + newValue + "'" ;
    }
}
