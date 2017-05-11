package com.company.controller.query.builder;

import com.company.controller.query.parameter.QueryParameters;
import org.springframework.stereotype.Component;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class DropQueryBuilder implements QueryBuilder {
    public String build(QueryParameters queryParameters) {
        return "DROP TABLE " + queryParameters.getTableName();
    }
}
