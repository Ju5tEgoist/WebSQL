package com.company.controller.servise;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

/**
 * Created by yulia on 06.04.17.
 */
public interface Service {
    Map<String, String> getCommandsList();
    Set<String> getList() throws SQLException;
}
