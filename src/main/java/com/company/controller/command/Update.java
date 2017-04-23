package com.company.controller.command;

import com.company.controller.query.builder.UpdateTableQueryBuilder;
import com.company.model.DatabaseManager;
import com.company.view.TablePresenter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yulia on 21.02.17.
 */
public class Update implements Command {


    @Override
    public boolean shouldExecute(String command) {
        return "update".equals(command);
    }

    @Override
    public void execute() throws SQLException {
//       // String tableName = new ClearParametersProvider().getParameters().getTableName();
//        TablePresenter tablePresenter = new TablePresenter();
//        view.write("This table: ");
//        ResultSet rs = getResultSet(tableName);
//      //  tablePresenter.showTable(tableName);
//        UpdateTableQueryBuilder updateTableQueryBuilder = new UpdateTableQueryBuilder();
//        updateTableQueryBuilder.build(tableName, rs, getColumnNumber());
//     //   tablePresenter.showTable(tableName);
    }

    private int getColumnNumber() {
//        view.write("Now enter the column number in which you want change value");
//        return Integer.valueOf(view.read());
        return 1;
    }

    private ResultSet getResultSet(String tableName) throws SQLException {
        ResultSet rs = new DatabaseManager().getStatement().executeQuery("SELECT * FROM " + tableName);
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            String columnName = rs.getMetaData().getColumnName(i);
            System.out.print(i > 1 ? "|" + columnName : columnName);
        }
        return rs;
    }
}
