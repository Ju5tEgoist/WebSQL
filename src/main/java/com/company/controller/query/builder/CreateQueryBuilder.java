package com.company.controller.query.builder;

import com.company.controller.query.executor.UpdateSqlQueryExecutor;
import com.company.controller.query.parameter.QueryParameters;
import com.company.model.CreateColumnDefinition;
import com.company.model.CreateColumnDefinitionPropertiesProvider;
import com.company.model.PostgresSQLDatabaseConnector;
import com.company.model.SQLDatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yulia on 21.02.17.
 */
@Component
public class CreateQueryBuilder implements QueryBuilder {

    @Autowired
    QueryParameters queryParameters;
    @Autowired
    SQLDatabaseConnector sqlDatabaseConnector;
    @Autowired
    UpdateSqlQueryExecutor updateSqlQueryExecutor;

    @Override
    public String build(QueryParameters queryParameters) {
        String properties = "";
        CreateColumnDefinitionPropertiesProvider columnDefinitionProvider = new CreateColumnDefinitionPropertiesProvider();
        List<CreateColumnDefinition> columnDefinition = columnDefinitionProvider.getProperties(queryParameters.getColumnsNumber(), queryParameters.getColumnsName());
        properties = getQueryProperties(properties, columnDefinition);
        return "CREATE TABLE " + queryParameters.getTableName() + "(" + properties + ")";
    }

    private String getQueryProperties(String properties, List<CreateColumnDefinition> columnDefinition) {
        for (int i = 0; i < columnDefinition.size(); i++){
            properties +=  i > 0 ?  "," + " " + columnDefinition.get(i).getName() + " "
                 + columnDefinition.get(i).getDataType() + " " + columnDefinition.get(i).getDefaultValue() :
                 columnDefinition.get(i).getName() + " " + columnDefinition.get(i).getDataType()
                            + " " + columnDefinition.get(i).getDefaultValue();
        }
        return properties;
    }
}
