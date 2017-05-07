package com.company.controller.query.builder;

import org.springframework.stereotype.Component;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class ClearQueryBuilder {
    public String build(String tableName) {
        return "DELETE FROM " + tableName;
    }
}
