package com.company.model.query.builder;

import com.company.model.query.parameter.QueryParameters;
import org.springframework.stereotype.Component;

/**
 * Created by yulia on 05.03.17.
 */
@Component
public class ClearQueryBuilder implements QueryBuilder{

    @Override
    public String build(QueryParameters queryParameters) {
        return "DELETE FROM " + queryParameters.getTableName();
    }
}
