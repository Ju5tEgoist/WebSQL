package com.company.controller.actions;

import com.company.controller.AbstractAction;
import com.company.controller.query.parameter.QueryParameters;
import com.company.controller.service.Service;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yulia on 16.05.17.
 */
@Component
public class Insert extends AbstractAction {

    @Override
    public boolean canProcess(String action) {
        return "/insert".equals(action);
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        queryParameters.setTableName(req.getParameter("tName"));
        try {
            req.getRequestDispatcher("insertColumns.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        queryParameters.setCounter(1);
    }

    @Override
    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("insert.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
