package com.company.controller.actions;

import com.company.controller.AbstractAction;
import com.company.controller.query.parameter.QueryParameters;
import com.company.controller.service.Service;
import com.company.controller.web.MainServlet;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yulia on 16.05.17.
 */
@Component
public class Help extends AbstractAction {

    @Override
    public boolean canProcess(String action) {
        return "/help".equals(action);
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        MainServlet mainServlet = new MainServlet();
        try {
            mainServlet.doGet(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("items", service.getCommandsList());
        try {
            req.getRequestDispatcher("help.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
