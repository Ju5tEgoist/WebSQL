package com.company.view;

import com.company.model.DatabaseManager;
import com.company.model.FindProperties;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yulia on 02.03.17.
 */
public class TablePresenter {


    public List<String> getTableData(String selectedTableName, int limit, int offset) throws SQLException {
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
        int columnCount = ps.getMetaData().getColumnCount();
        List<String> tableData = new LinkedList<>();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                tableData.add(rs.getString(i) + " ");
            }
        }
        return tableData;
    }

//    public void showColumns(String tableName) throws SQLException {
//        view.write("This table: ");
//        ResultSet rs = new DatabaseManager().getStatement().executeQuery("SELECT * FROM " + tableName);
//        ResultSetMetaData metaData = rs.getMetaData();
//        for (int i = 1; i <= metaData.getColumnCount(); i++) {
//            System.out.print(i > 1 ? "|" + metaData.getColumnName(i) : metaData.getColumnName(i));
//        }
//        view.write("\n");
//    }
}
