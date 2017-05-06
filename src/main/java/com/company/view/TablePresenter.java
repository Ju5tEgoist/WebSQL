package com.company.view;

import com.company.model.DatabaseManager;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

/**
 * Created by yulia on 02.03.17.
 */
@Component
public class TablePresenter {


    public Map<String, List<String>> getTableData(String selectedTableName, int limit, int offset) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement ps;
        if(limit != 0 && offset != 0){
            String s = "SELECT * FROM " + selectedTableName + " " + "LIMIT " + limit + " " +  "OFFSET" + " " + offset;
            ps = connection.prepareStatement(s);
        }
        else {
            ps = connection.prepareStatement("select * from " + selectedTableName);
        }
        ResultSet rs = ps.executeQuery();
        Map<String, List<String>> tableData = new HashMap<>();
        ResultSetMetaData metaData = rs.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            rs = ps.executeQuery();
            List<String> columnValues = new LinkedList<>();
        while (rs.next()) {
            columnValues.add(rs.getString(i));
        }
            tableData.put(rs.getMetaData().getColumnName(i), columnValues);
        }
        return tableData;
    }
}
