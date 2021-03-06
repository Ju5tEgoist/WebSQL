package com.company.model.query.builder;

import com.company.model.query.parameter.QueryParameters;
import com.company.model.SQLDatabaseConnector;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 09.05.17.
 */
@Component
public class InsertQueryBuilder implements QueryBuilder {

    @Autowired
    SQLDatabaseConnector sqlDatabaseConnector;

    @Autowired
    QueryParameters queryParameters;

    public List getInsertColumnsName() throws SQLException {
        List<String> insertColumnsName = new ArrayList<>();
        String query = "SELECT * FROM " + queryParameters.getTableName();
        ResultSet rs = sqlDatabaseConnector.getConnection().createStatement().executeQuery(query);
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            insertColumnsName.add(rs.getMetaData().getColumnName(i));
        }
        return insertColumnsName;
    }
    @Override
    public String build(QueryParameters queryParameters) throws SQLException {
        List<String> insertColumnsName = getInsertColumnsName();
        return "INSERT INTO " + queryParameters.getTableName() + " " + "("
                + StringUtils.join(insertColumnsName, ",")
                + ")" + " " + "VALUES" + " " + "(" + StringUtils.join(queryParameters.getInsertValues(),
                ",") + ")";
    }

}
