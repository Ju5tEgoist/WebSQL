package com.company.controller.query.builder;
import com.company.controller.query.parameter.QueryParameters;
import org.springframework.stereotype.Component;
import java.sql.SQLException;

/**
 * Created by yulia on 23.02.17.
 */
@Component
public class UpdateTableQueryBuilder implements QueryBuilder {
    @Override
    public String build(QueryParameters queryParameters) throws SQLException {
        return "UPDATE " + queryParameters.getTableName() + " " + "SET" + " "
                + queryParameters.getColumn() + " " + "=" + " " + queryParameters.getNewValue() + " "
                + "WHERE" + " " + queryParameters.getColumn() + " " + "=" + queryParameters.getOldValue() ;
    }
}
