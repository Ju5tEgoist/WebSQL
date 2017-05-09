package com.company.controller.query.builder;
import org.springframework.stereotype.Component;
import java.sql.SQLException;

/**
 * Created by yulia on 23.02.17.
 */
@Component
public class UpdateTableQueryBuilder {
    public String build(String tableName, String column, String newValue, String oldValue) throws SQLException {
        String sql = "UPDATE " + tableName + " " + "SET" + " " + column + " " + "=" + " "
                + newValue + " " + "WHERE" + " " + column + " " + "=" + oldValue ;
        return sql;
    }
}
