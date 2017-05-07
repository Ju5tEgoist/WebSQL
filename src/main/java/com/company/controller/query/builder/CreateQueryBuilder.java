package com.company.controller.query.builder;

import com.company.controller.query.executor.UpdateSqlQueryExecutor;
import com.company.controller.query.parameter.CreateParameters;
import com.company.controller.query.parameter.Parameters;
import com.company.model.CreateColumnDefinition;
import com.company.model.CreateColumnDefinitionPropertiesProvider;
import com.company.model.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yulia on 21.02.17.
 */
@Component
public class CreateQueryBuilder {

    @Autowired
    CreateParameters createParameters;
    @Autowired
    com.company.controller.service.Service service;
    @Autowired
    DatabaseManager databaseManager;
    @Autowired
    UpdateSqlQueryExecutor updateSqlQueryExecutor;

    public String build(List<String> columnsName, int columnsNumber, String tableName) {
        String properties = "";
        CreateColumnDefinitionPropertiesProvider columnDefinitionProvider = new CreateColumnDefinitionPropertiesProvider();
        List<CreateColumnDefinition> columnDefinition = columnDefinitionProvider.getProperties(columnsNumber,columnsName);
        properties = getQueryProperties(properties, columnDefinition);
        System.out.println("CREATE TABLE " + tableName + "(" + properties + ")");
        return "CREATE TABLE " + tableName + "(" + properties + ")";
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

    public void setCreateParameters() throws SQLException {
        createParameters.setTableName(service.getTableName());
        createParameters.setColumnNumber(service.getColumnsNumber());
        updateSqlQueryExecutor.execute(build(service.getColumnsName(), service.getColumnsNumber(), service.getTableName()));
    }
}
