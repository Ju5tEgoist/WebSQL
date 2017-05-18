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
public class Connect extends AbstractAction {

    @Override
    public boolean canProcess(String action) {
        return action.startsWith("/connect");
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        queryParameters.setDatabase(req.getParameter("dbname"));
        queryParameters.setUserName(req.getParameter("username"));
        queryParameters.setPassword(req.getParameter("password"));
        try {
            service.connect();
            resp.sendRedirect(resp.encodeRedirectURL("menu"));
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            try {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } catch (ServletException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("connect.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
