package com.company.controller.query.builder;

import com.company.model.DatabaseManager;
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
public class InsertQueryBuilder {

    @Autowired
    DatabaseManager databaseManager;
    private String tableName;
    private List<String> insertValues = new ArrayList<>();


    public void setTableName(String tName) {
        this.tableName = tName;
    }

    public String getTableName() {
        return tableName;
    }

    public void addValue(String value) {insertValues.add("'" + value + "'");}

    public int getInsertColumnsNumber() throws SQLException {
        String query = "SELECT * FROM " + tableName;
        ResultSet rs = databaseManager.getStatement().executeQuery(query);
        return rs.getMetaData().getColumnCount();
    }
    private List getInsertColumnsName(String tableName) throws SQLException {
        List<String> insertColumnsName = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;
        ResultSet rs = databaseManager.getStatement().executeQuery(query);
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            insertColumnsName.add(rs.getMetaData().getColumnName(i));
        }
        return insertColumnsName;
    }

    public String build() throws SQLException {
        List<String> insertColumnsName = getInsertColumnsName(tableName);
        return "INSERT INTO " + tableName + " " + "(" + StringUtils.join(insertColumnsName, ",")
                + ")" + " " + "VALUES" + " " + "(" + StringUtils.join(insertValues, ",") + ")";
    }

}
