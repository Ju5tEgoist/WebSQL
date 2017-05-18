package com.company.controller.actions;

import com.company.controller.AbstractAction;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by yulia on 16.05.17.
 */
@Component
public class Menu extends AbstractAction {

    @Override
    public boolean canProcess(String action) {
        return "/menu".equals(action);
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        //do nothing
    }

    @Override
    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("items", service.getCommandsList().keySet());
        try {
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
