package com.company.controller.command;

import com.company.controller.query.builder.DropQueryBuilder;
import com.company.controller.query.executor.UpdateSqlQueryExecutor;
import com.company.model.exception.CommandExecutionException;


/**
 * Created by yulia on 21.02.17.
 */
public class Drop extends AbstractCommand {

    public Drop() {
        super(null, new DropQueryBuilder(), new UpdateSqlQueryExecutor());
    }

   @Override
    public boolean shouldExecute(String command) {
        return "drop".equals(command);
    }

   @Override
    public void execute() throws CommandExecutionException {
        super.execute();
    }
}
