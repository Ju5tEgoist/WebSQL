package com.company.model;

import com.company.controller.servise.Service;
import com.company.controller.servise.ServiceImp;
import com.company.view.TablePresenter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by yulia on 04.10.16.
 */
public class FindProperties {

    TablePresenter tablePresenter = new TablePresenter();
    Service service = new ServiceImp();
    String selectedTableName;

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
        String[] tableNames = service.getList().toArray(new String[service.getList().size()]);;
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
