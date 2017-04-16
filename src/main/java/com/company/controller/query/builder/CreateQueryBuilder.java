package com.company.controller.query.builder;

import com.company.model.CreateColumnDefinition;
import com.company.model.CreateColumnDefinitionPropertiesProvider;
import java.util.List;

/**
 * Created by yulia on 21.02.17.
 */
public class CreateQueryBuilder{

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
}
