package com.company.controller.service;

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
}
