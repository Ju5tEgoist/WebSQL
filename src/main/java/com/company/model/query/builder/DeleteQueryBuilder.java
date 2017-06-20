package com.company.model.query.builder;


import com.company.model.query.parameter.QueryParameters;
import org.springframework.stereotype.Component;


/**
 * Created by yulia on 23.02.17.
 */
@Component
public class DeleteQueryBuilder implements QueryBuilder {

    @Override
    public String build(QueryParameters queryParameters){
        return  "DELETE FROM " + queryParameters.getTableName() + " " + "WHERE" + " "
                + queryParameters.getColumn() + " " + "=" + " " + "'" + queryParameters.getValue() + "'";
    }
}
