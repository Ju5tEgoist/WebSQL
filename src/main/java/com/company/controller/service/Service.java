package com.company.controller.service;

import com.company.model.SQLDatabaseConnector;
import com.company.model.query.parameter.QueryParameters;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yulia on 06.04.17.
 */

public interface Service {

    Map<String, String> getCommandsList();

    Set<String> getList() throws SQLException;

    String updateTable() throws SQLException;

    Map<String, List<String>> tablePresenter(String tableName, String limitOffset) throws SQLException;

    void dropTable() throws SQLException;

    void clearTable() throws SQLException;

    void createTable() throws SQLException;

    void delete() throws SQLException;

    void insert() throws SQLException;

    void execute(String query) throws SQLException;

    void update() throws SQLException;

    int getInsertColumnsNumber(QueryParameters queryParameters) throws SQLException;

    SQLDatabaseConnector connect(String dbName, String userName, String password);

    List getInsertColumnsName() throws SQLException;

}
