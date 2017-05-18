package com.company.controller.actions;

import com.company.controller.AbstractAction;
import com.company.controller.query.parameter.QueryParameters;
import com.company.controller.service.Service;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yulia on 16.05.17.
 */
@Component
public class TableDelete extends AbstractAction {

    @Override
    public boolean canProcess(String action) {
        return "/tableDelete".equals(action);
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        queryParameters.setValue(req.getParameter("value"));
        queryParameters.setColumn(req.getParameter("columnName"));
        try {
            service.delete();
            resp.sendRedirect(resp.encodeRedirectURL("menu"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
        //do nothing
    }
}
