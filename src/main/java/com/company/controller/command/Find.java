package com.company.controller.command;

import com.company.model.FindProperties;

import java.sql.SQLException;

/**
 * Created by yulia on 06.11.16.
 */
public class Find implements Command {

    @Override
    public boolean shouldExecute(String command) {
        return command.startsWith("find");
    }

    @Override
    public void execute() throws SQLException {
        FindProperties findProperties = new FindProperties();

      //  findProperties.tablePresentationLO(tableNames, result, parts);
    }
}
