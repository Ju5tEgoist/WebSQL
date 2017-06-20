package com.company.model.query.builder;

import com.company.model.query.parameter.QueryParameters;
import java.sql.SQLException;

/**
 * Created by yulia on 11.05.17.
 */
public interface QueryBuilder {
    String build(QueryParameters queryParameters) throws SQLException;
}
