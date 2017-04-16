package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 21.02.17.
 */
public class CreateColumnDefinitionPropertiesProvider {
    public List<CreateColumnDefinition>  getProperties(Integer columnNumber, List<String> columnsName) {
        List<CreateColumnDefinition> columnDefinitions = new ArrayList<>();
        for (int i = 0; i < columnNumber; i++) {
            CreateColumnDefinition columnDefinition = CreateColumnDefinition.builder()
                    .name(columnsName.get(i))
                    .nullable(false)
                    .dataType("text")
                    .build();
            columnDefinitions.add(columnDefinition);
        }
        return columnDefinitions;
    }
}
