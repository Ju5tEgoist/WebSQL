package com.company.controller.query.builder;

import com.company.controller.query.parameter.QueryParameters;
import com.company.controller.query.parameter.QueryParametersImpl;
import org.springframework.stereotype.Component;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class DropQueryBuilder implements QueryBuilder {
    @Override
    public String build(QueryParameters queryParameters) {
        return "DROP TABLE " + queryParameters.getTableName();
    }
}
