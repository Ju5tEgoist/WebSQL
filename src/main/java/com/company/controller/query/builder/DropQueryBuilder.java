package com.company.controller.query.builder;

/**
 * Created by yulia on 05.03.17.
 */
public class DropQueryBuilder {
    public String build(String tableName) {
        return "DROP TABLE " + tableName;
    }
}
