package com.company.controller.servise;

import com.company.controller.query.builder.CreateQueryBuilder;
import com.company.controller.query.builder.UpdateTableQueryBuilder;
import com.company.controller.query.parameter.ConnectParameters;
import com.company.controller.query.parameter.CreateParameters;
import com.company.model.DatabaseManager;
import org.apache.commons.lang3.StringUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by yulia on 06.04.17.
 */
public class ServiceImp implements Service {

    private List<String> columnsName = new ArrayList<>();
    private List<String> insertValues = new ArrayList<>();
    private int columnsNumber;
    private String tableName;
    private int i = 1;
    private String column;
    private String oldValue;
    private String newValue;
    private List<String> commands = Arrays.asList("help", "connect", "clear", "drop", "create", "insert", "update",
            "delete", "list", "find", "exit");

    private List<String> comments = Arrays.asList("show all command", "connect to database",
            "clears the contents of the specified table", "drops the specified table", "create new table",
            "add row in the table", "change value", "delete value", "review all user's tables",
            "find and view table in database", "");

    private LinkedHashMap<String, String> commandsList = new LinkedHashMap<>();

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
        ResultSet resultSet = DatabaseManager.getConnection().getMetaData().getTables(new ConnectParameters()
                .getDatabase(), "public", "%", null);
        int databaseIndex = 3;
        while (resultSet.next()) {
             list.add(resultSet.getString(databaseIndex));
        }
        return list;
    }

    @Override
    public void dropTable(String tableName) throws SQLException {
       String query = "DROP TABLE " + tableName;
       DatabaseManager databaseManager = new DatabaseManager();
       databaseManager.getStatement().executeUpdate(query);
    }

    @Override
    public void clearTable(String tableName) throws SQLException {
        String query = "DELETE FROM " + tableName;
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.getStatement().executeUpdate(query);
    }

    @Override
    public void getCreateParameters() throws SQLException {
        CreateParameters createParameters = new CreateParameters();
        createParameters.setTableName(getTableName());
        createParameters.setColumnNumber(getColumnsNumber());
        CreateQueryBuilder createQueryBuilder = new CreateQueryBuilder();
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.getStatement().executeUpdate(createQueryBuilder.build(getColumnsName(), getColumnsNumber(), getTableName()));
    }

    @Override
    public void addName(String columnName) {
        columnsName.add(columnName);
    }

    @Override
    public void addValue(String value) {insertValues.add("'" + value + "'");}

    @Override
    public List<String> getColumnsName() {
        return columnsName;
    }



    @Override
    public int getCounter() {
        return i++;
    }



    @Override
    public void setColumnsNumber(String columnsNumber) {
        this.columnsNumber = Integer.parseInt(columnsNumber);
    }

    @Override
    public int getColumnsNumber() {
        return columnsNumber;
    }

    @Override
    public void setCounter(int counter) {
        this.i = counter;
    }

    @Override
    public void setTableName(String tName) {
        this.tableName = tName;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public int getInsertColumnsNumber() throws SQLException {
        String query = "SELECT * FROM " + tableName;
        DatabaseManager databaseManager = new DatabaseManager();
        ResultSet rs = databaseManager.getStatement().executeQuery(query);
        return rs.getMetaData().getColumnCount();
    }

    @Override
    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public void setOldValue(String oldValue) {
        this.oldValue = "'" + oldValue + "'";
    }

    @Override
    public void setNewValue(String newValue) {
        this.newValue = "'" + newValue + "'" ;
    }

    @Override
    public List getInsertColumnsName(String tableName) throws SQLException {
        List<String> insertColumnsName = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;
        DatabaseManager databaseManager = new DatabaseManager();
        ResultSet rs = databaseManager.getStatement().executeQuery(query);
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            insertColumnsName.add(rs.getMetaData().getColumnName(i));
        }
        return insertColumnsName;
    }

    @Override
    public void insertData() throws SQLException {
        List<String> insertColumnsName = getInsertColumnsName(tableName);
        String query = "INSERT INTO " + tableName + " " + "(" + StringUtils.join(insertColumnsName, ",") + ")" + " "
                + "VALUES" + " " + "(" + StringUtils.join(insertValues, ",") + ")";
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.getStatement().executeQuery(query);
    }

    @Override
    public void updateTable() throws SQLException {
        UpdateTableQueryBuilder updateTableQueryBuilder = new UpdateTableQueryBuilder();
        updateTableQueryBuilder.build(tableName, column, newValue, oldValue);
    }
}
