package com.company.controller.query.parameter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class Parameters {
    private List<String> columnsName = new ArrayList<>();
    private int columnsNumber;
    private String tableName;
    private int i = 1;

    public String getColumn() {
        return column;
    }

    private String column;

    public String getOldValue() {
        return oldValue;
    }

    private String oldValue;

    public String getNewValue() {
        return newValue;
    }

    private String newValue;

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
