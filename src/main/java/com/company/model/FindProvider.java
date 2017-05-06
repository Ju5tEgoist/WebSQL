package com.company.model;

import com.company.controller.service.Service;
import com.company.view.TablePresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yulia on 04.10.16.
 */
@Component
public class FindProvider {

    @Autowired
    private TablePresenter tablePresenter;
    @Autowired
    private Service service;

    private String selectedTableName;

    public Map<String, List<String>> tablePresentationLO(String tableNameUser, String limitOffset) throws SQLException {
        int limit = 0;
        int offset = 0;
        String limitString;
        String offsetString;
        String[] partsLO = limitOffset.split("/");
        limitString = partsLO[0];
        offsetString = partsLO[1];
        limit = Integer.parseInt(limitString);
        offset = Integer.parseInt(offsetString);
        getSelectedTableName(tableNameUser);
        return tablePresenter.getTableData(selectedTableName, limit, offset);
    }

    private String getSelectedTableName(String tableNameUser) throws SQLException {
        Set<String> list = service.getList();
        String[] tableNames = list.toArray(new String[list.size()]);
        for (String tableName : tableNames) {
            if (tableName.equals(tableNameUser)) {
                selectedTableName = tableName;
                break;
            }
        }
        if(selectedTableName == null){
            throw new NullPointerException();
        }
        return selectedTableName;
    }


    public Map<String, List<String>> tablePresentation(String tableNameUser, String limitOffset) throws SQLException {
        if (!limitOffset.equals("")) {
            tablePresentationLO(tableNameUser, limitOffset);
        }
            getSelectedTableName(tableNameUser);
            return tablePresenter.getTableData(selectedTableName, 0, 0);
    }
}
