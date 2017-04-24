package com.company.controller.command;

import com.company.controller.query.executor.UpdateSqlQueryExecutor;
import com.company.model.exception.CommandExecutionException;

/**
 * Created by yulia on 21.02.17.
 */
public class Insert extends AbstractCommand {

    public Insert() {
        super(null, null, new UpdateSqlQueryExecutor());
    }

    @Override
    public boolean shouldExecute(String command) {
        return "insert".equals(command);
    }

    @Override
    public void execute() throws CommandExecutionException {
        super.execute();
//        View view = new ConsoleManager();
//        view.write("Your data were added");
    }
}
