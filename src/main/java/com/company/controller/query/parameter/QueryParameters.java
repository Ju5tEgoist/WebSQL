package com.company.controller.query.parameter;

import java.util.List;

/**
 * Created by yulia on 11.05.17.
 */
public interface QueryParameters {
    List<String> getInsertValues();

    void addValue(String value);

    String getValue();

    void setValue(String value);

    String getDatabase();

    String getColumn();

    String getOldValue();

    String getNewValue();

    void addName(String columnName);

    List<String> getColumnsName();

    int getCounter();

    void setColumnsNumber(String columnsNumber);

    int getColumnsNumber();

    void setCounter(int counter);

    void setTableName(String tName);

    String getTableName();

    void setColumn(String column);

    void setOldValue(String oldValue);

    void setNewValue(String newValue);
}
