package com.company.controller.actions;

import com.company.controller.AbstractAction;
import com.company.controller.query.parameter.QueryParameters;
import com.company.controller.service.Service;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by yulia on 16.05.17.
 */
@Component
public class Update extends AbstractAction {

    @Override
    public boolean canProcess(String action) {
        return "/update".equals(action);
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        String tableName = req.getParameter("tName");
        queryParameters.setTableName(tableName);
        try {
            req.setAttribute("tabledata", service.tablePresenter(tableName, ""));
            req.getRequestDispatcher("updateTable.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
