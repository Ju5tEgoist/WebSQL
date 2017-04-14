package com.company.controller.web;

import com.company.controller.servise.Service;
import com.company.controller.servise.ServiceImp;
import com.company.model.DatabaseManager;
import com.company.model.FindProperties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by yulia on 03.04.17.
 */
public class MainServlet extends HttpServlet {

    Service service;
    @Override
    public void init() throws ServletException {
        super.init();
        service = new ServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
//        forwardToJSP(action, req, resp);
        if (action.startsWith("/menu") || action.equals("/")) {
            req.setAttribute("items", service.getCommandsList().keySet());
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } else if (action.startsWith("/help")) {
            req.setAttribute("items", service.getCommandsList());
            req.getRequestDispatcher("help.jsp").forward(req, resp);
        } else if (action.startsWith("/connect")) {
            req.getRequestDispatcher("connect.jsp").forward(req, resp);
        } else if (action.startsWith("/list")){
            try {
                req.setAttribute("items", service.getList());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        } else if (action.startsWith("/find")) {
            req.getRequestDispatcher("find.jsp").forward(req, resp);
        }else if(action.startsWith("/drop")){
            req.getRequestDispatcher("drop.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return requestURI.substring(req.getContextPath().length(), requestURI.length());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        if (action.startsWith("/connect")) {
            String databaseName = req.getParameter("dbname");
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            try {
                DatabaseManager.connect(databaseName, userName, password);
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (Exception e) {
                req.setAttribute("message", e.getMessage());
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }
        if (action.startsWith("/find")) {
            String tableName = req.getParameter("tName");
            String limitOffset = req.getParameter("LO");
            FindProperties findProperties = new FindProperties();
            try {
                req.setAttribute("tabledata", findProperties.tablePresentation(tableName, limitOffset));
                req.getRequestDispatcher("table.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.startsWith("/drop")) {
            String tableName = req.getParameter("tName");
            try {
                service.dropTable(tableName);
           // TODO forward to menu
                //     req.getRequestDispatcher("menu.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    private void forwardToJSP(String action, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        for (String command : service.getCommandsList().keySet()) {
//            if (action.startsWith("/" + command)) {
//                req.setAttribute("items", service.getCommandsList());
//                req.getRequestDispatcher( command +".jsp").forward(req, resp);
//            }
//        }
//    }
}
