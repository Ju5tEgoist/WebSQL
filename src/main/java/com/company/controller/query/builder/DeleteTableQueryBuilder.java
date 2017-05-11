package com.company.controller.query.builder;


import com.company.controller.query.parameter.QueryParameters;
import org.springframework.stereotype.Component;


/**
 * Created by yulia on 23.02.17.
 */
@Component
public class DeleteTableQueryBuilder implements QueryBuilder {

    @Override
    public String build(QueryParameters queryParameters){
        return  "DELETE FROM " + queryParameters.getTableName() + " " + "WHERE" + " "
                + queryParameters.getColumn() + " " + "=" + " " + "'" + queryParameters.getValue() + "'";
    }
}
