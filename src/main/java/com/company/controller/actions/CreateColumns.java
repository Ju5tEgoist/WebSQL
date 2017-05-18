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
public class CreateColumns extends AbstractAction {

    @Override
    public boolean canProcess(String action) {
        return "/createColumns".equals(action);
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        String columnName = req.getParameter("cName");
        queryParameters.setColumn(columnName);
        queryParameters.addName(columnName);
        if(queryParameters.getCounter() < queryParameters.getColumnsNumber()){
            try {
                req.getRequestDispatcher("createColumns.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }         }
        else {
            try {
                service.createTable();
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
        //do nothing
    }
}
