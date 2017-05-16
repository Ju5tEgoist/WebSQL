package com.company.controller.query.builder;

import com.company.controller.query.parameter.QueryParameters;
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

    private List getInsertColumnsName(QueryParameters queryParameters)  {
        List<String> insertColumnsName = new ArrayList<>();
        String query = "SELECT * FROM " + queryParameters.getTableName();
        ResultSet rs = null;
        try {
            rs = sqlDatabaseConnector.getConnection().createStatement().executeQuery(query);
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                insertColumnsName.add(rs.getMetaData().getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return insertColumnsName;
    }
    @Override
    public String build(QueryParameters queryParameters)  {
        List<String> insertColumnsName = getInsertColumnsName(queryParameters);
        return "INSERT INTO " + queryParameters.getTableName() + " " + "("
                + StringUtils.join(insertColumnsName, ",")
                + ")" + " " + "VALUES" + " " + "(" + StringUtils.join(queryParameters.getInsertValues(),
                ",") + ")";
    }

}
