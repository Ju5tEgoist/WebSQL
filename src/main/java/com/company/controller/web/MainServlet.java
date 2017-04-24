package com.company.controller.web;

import com.company.controller.command.Delete;
import com.company.controller.servise.Service;
import com.company.controller.servise.ServiceImp;
import com.company.model.DatabaseManager;
import com.company.model.FindProperties;
import com.company.model.exception.CommandExecutionException;

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
    Delete delete;
    @Override
    public void init() throws ServletException {
        super.init();
        service = new ServiceImp();
        delete = new Delete();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        //forwardToJSP(action, req, resp);
        if (action.startsWith("/menu") || action.equals("/")) {
            req.setAttribute("items", service.getCommandsList().keySet());
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        }
        if (action.startsWith("/help")) {
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
        }else if(action.startsWith("/clear")){
            req.getRequestDispatcher("clear.jsp").forward(req, resp);
        }else if(action.equals("/create")){
            req.getRequestDispatcher("create.jsp").forward(req, resp);
        }else if(action.equals("/insert")){
            req.getRequestDispatcher("insert.jsp").forward(req, resp);
        }else if(action.equals("/delete")){
            req.getRequestDispatcher("delete.jsp").forward(req, resp);
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
        } else if (action.startsWith("/find")) {
            String tableName = req.getParameter("tName");
            String limitOffset = req.getParameter("LO");
            FindProperties findProperties = new FindProperties();
            try {
                req.setAttribute("tabledata", findProperties.tablePresentation(tableName, limitOffset));
                req.getRequestDispatcher("table.jsp").forward(req, resp);
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.startsWith("/drop")) {
            String tableName = req.getParameter("tName");
            try {
                service.dropTable(tableName);
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.startsWith("/clear")) {
            String tableName = req.getParameter("tName");
            try {
                service.clearTable(tableName);
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("/create")) {
            service.setTableName(req.getParameter("tName"));
            service.setColumnsNumber(req.getParameter("cNumber"));
            req.getRequestDispatcher("createColumns.jsp").forward(req, resp);
            service.setCounter(1);
        } else if (action.equals("/createColumns")) {
            String columnName = req.getParameter("cName");
            service.addName(columnName);
            if(service.getCounter() < service.getColumnsNumber()){
                req.getRequestDispatcher("createColumns.jsp").forward(req, resp);

            }
            else {
                try {
                    service.getCreateParameters();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
              //  req.getRequestDispatcher("menu.jsp").forward(req, resp);
            }
        }
        else if (action.equals("/delete")) {
            String tableName = req.getParameter("tName");
            FindProperties findProperties = new FindProperties();
            try {
                delete.setTableName(tableName);
                req.setAttribute("tabledata", findProperties.tablePresentation(tableName, ""));
                req.getRequestDispatcher("tableDelete.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(action.equals("/tableDelete")){
            String value = req.getParameter("value");
            String columnName = req.getParameter("columnName");
            delete.setColumnName(columnName);
            delete.setValue(value);
            try {
                 delete.execute();
            } catch (CommandExecutionException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect(resp.encodeRedirectURL("menu"));
        } else if (action.equals("/insert")) {
            service.setTableName(req.getParameter("tName"));
            req.getRequestDispatcher("insertColumns.jsp").forward(req, resp);
            service.setCounter(1);
        } else if (action.equals("/insertColumns")) {
            String value = req.getParameter("value");
            service.addValue(value);
            try {
                if(service.getCounter() < service.getInsertColumnsNumber()){
                    req.getRequestDispatcher("insertColumns.jsp").forward(req, resp);

                }
                else {
                    try {
                        service.insertData();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    resp.sendRedirect(resp.encodeRedirectURL("find"));
                    //  req.getRequestDispatcher("menu.jsp").forward(req, resp);
                }
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
