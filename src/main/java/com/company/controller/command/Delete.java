package com.company.controller.command;

import com.company.controller.query.builder.DeleteTableQueryBuilder;
import com.company.model.exception.CommandExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by yulia on 21.02.17.
 */
@Component
public class Delete implements Command {
    private String tableName;
    private String columnName;
    private String value;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
            this.tableName = tableName;
    }

    @Override
    public boolean shouldExecute(String command) {
        return "delete".equals(command);
    }

    @Override
    public void execute() throws CommandExecutionException, SQLException {
        DeleteTableQueryBuilder updateTableQueryBuilder = new DeleteTableQueryBuilder();
        updateTableQueryBuilder.build(tableName, columnName, value);
    }
}
