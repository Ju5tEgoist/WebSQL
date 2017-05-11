package com.company.controller.service;

import com.company.controller.query.builder.*;
import com.company.controller.query.executor.UpdateSqlQueryExecutor;
import com.company.controller.query.parameter.QueryParameters;
import com.company.model.DatabaseManager;
import com.company.model.FindProvider;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by yulia on 06.04.17.
 */
@org.springframework.stereotype.Service
public class ServiceImp implements Service {

    private DatabaseManager databaseManager;
    private UpdateTableQueryBuilder updateTableQueryBuilder;
    private QueryParameters queryParameters;
    private FindProvider findProvider;
    private UpdateSqlQueryExecutor updateSqlQueryExecutor;
    private DropQueryBuilder dropQueryBuilder;
    private ClearQueryBuilder clearQueryBuilder;
    private CreateQueryBuilder createQueryBuilder;
    private DeleteQueryBuilder deleteQueryBuilder;
    private InsertQueryBuilder insertQueryBuilder;

    private List<String> commands = Arrays.asList("help", "connect", "clear", "drop", "create", "insert", "update",
            "delete", "list", "find", "exit");

    private List<String> comments = Arrays.asList("show all command", "connect to database",
            "clears the contents of the specified table", "drops the specified table", "create new table",
            "add row in the table", "change value", "delete value", "review all user's tables",
            "find and view table in database", "");

    private LinkedHashMap<String, String> commandsList = new LinkedHashMap<>();

    @Autowired
    public ServiceImp(DatabaseManager databaseManager, UpdateTableQueryBuilder updateTableQueryBuilder, QueryParameters queryParameters, FindProvider findProvider, UpdateSqlQueryExecutor updateSqlQueryExecutor, DropQueryBuilder dropQueryBuilder, ClearQueryBuilder clearQueryBuilder, CreateQueryBuilder createQueryBuilder, DeleteQueryBuilder deleteQueryBuilder, InsertQueryBuilder insertQueryBuilder) {
        this.databaseManager = databaseManager;
        this.updateTableQueryBuilder = updateTableQueryBuilder;
        this.queryParameters = queryParameters;
        this.findProvider = findProvider;
        this.updateSqlQueryExecutor = updateSqlQueryExecutor;
        this.dropQueryBuilder = dropQueryBuilder;
        this.clearQueryBuilder = clearQueryBuilder;
        this.createQueryBuilder = createQueryBuilder;
        this.deleteQueryBuilder = deleteQueryBuilder;
        this.insertQueryBuilder = insertQueryBuilder;
    }

    @Override
    public LinkedHashMap<String, String> getCommandsList() {
        if(commandsList.size() == 0){
            for (int i = 0; i < commands.size(); i++) {
                commandsList.put(commands.get(i), comments.get(i));
            }
        }
        return commandsList;
    }

    @Override
    public Set<String> getList() throws SQLException {
        Set<String> list = new HashSet<>();
        ResultSet resultSet = databaseManager.getConnection().getMetaData().getTables(queryParameters
                .getDatabase(), "public", "%", null);
        int databaseIndex = 3;
        while (resultSet.next()) {
             list.add(resultSet.getString(databaseIndex));
        }
        return list;
    }

    @Override
    public String updateTable() throws SQLException {
        return updateTableQueryBuilder.build(queryParameters);
    }

    @Override
    public Map<String, List<String>> tablePresenter(String tableName, String limitOffset) throws SQLException {
        return findProvider.tablePresentation(tableName, limitOffset);
    }

    @Override
    public void dropTable() throws SQLException {
        execute(dropQueryBuilder.build(queryParameters));
    }

    @Override
    public void clearTable() throws SQLException {
        execute(clearQueryBuilder.build(queryParameters));
    }

    @Override
    public void createTable() throws SQLException {
        execute(createQueryBuilder.build(queryParameters));
    }

    @Override
    public void delete() throws SQLException {
        execute(deleteQueryBuilder.build(queryParameters));
    }

    @Override
    public void insert() throws SQLException {
        execute(insertQueryBuilder.build(queryParameters));
    }

    @Override
    public void execute(String query) throws SQLException {
       updateSqlQueryExecutor.execute(query);
    }

    @Override
    public void update() throws SQLException {
        execute(updateTable());
    }

    @Override
    public int getInsertColumnsNumber(QueryParameters queryParameters) throws SQLException {
        String query = "SELECT * FROM " + queryParameters.getTableName();
        ResultSet rs = databaseManager.getStatement().executeQuery(query);
        return rs.getMetaData().getColumnCount();
    }
}
