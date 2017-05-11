package com.company.controller.web;

import com.company.controller.query.parameter.QueryParameters;
import com.company.controller.service.Service;
import com.company.model.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import javax.servlet.ServletConfig;
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

    @Autowired
    Service service;
    QueryParameters queryParameters;


//    private List<String> commands = Arrays.asList("/menu", "/connect", "/find", "/drop", "/clear", "/create",
//            "/createColumns", "/delete", "/tableDelete", "/insert", "/insertColumns", "/update", "/updateTable" );

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
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
        }else if(action.equals("/deleteTableQueryBuilder")){
            req.getRequestDispatcher("deleteTableQueryBuilder.jsp").forward(req, resp);
        }else if(action.equals("/update")){
            req.getRequestDispatcher("update.jsp").forward(req, resp);
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
        if (action.equals("/connect")) {
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
        } else if (action.equals("/find")) {
            String tableName = req.getParameter("tName");
            String limitOffset = req.getParameter("LO");
            try {
                req.setAttribute("tabledata", service.tablePresenter(tableName, limitOffset));
                req.getRequestDispatcher("table.jsp").forward(req, resp);
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("/drop")) {
            String tableName = req.getParameter("tName");
            queryParameters.setTableName(tableName);
            try {
                service.dropTable();
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("/clear")) {
            String tableName = req.getParameter("tName");
            queryParameters.setTableName(tableName);
            try {
                service.clearTable();
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("/create")) {
            queryParameters.setTableName(req.getParameter("tName"));
            queryParameters.setColumnsNumber(req.getParameter("cNumber"));
            req.getRequestDispatcher("createColumns.jsp").forward(req, resp);
            queryParameters.setCounter(1);
        } else if (action.equals("/createColumns")) {
            String columnName = req.getParameter("cName");
            queryParameters.setColumn(columnName);
            queryParameters.addName(columnName);
            if(queryParameters.getCounter() < queryParameters.getColumnsNumber()){
                req.getRequestDispatcher("createColumns.jsp").forward(req, resp);
            }
            else {
                try {
                    service.createTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            }
        } else if (action.equals("/delete")) {
            String tableName = req.getParameter("tName");
            try {
                queryParameters.setTableName(tableName);
                req.setAttribute("tabledata", service.tablePresenter(tableName, ""));
                req.getRequestDispatcher("tableDelete.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if(action.equals("/tableDelete")){
            queryParameters.setValue(req.getParameter("value"));
            queryParameters.setColumn(req.getParameter("columnName"));
            try {
                service.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect(resp.encodeRedirectURL("menu"));
        } else if (action.equals("/insert")) {
            queryParameters.setTableName(req.getParameter("tName"));
            req.getRequestDispatcher("insertColumns.jsp").forward(req, resp);
            queryParameters.setCounter(1);
        } else if (action.equals("/insertColumns")) {
            String value = req.getParameter("value");
           queryParameters.addValue(value);
            try {
                if(queryParameters.getCounter() < service.getInsertColumnsNumber(queryParameters)){
                    req.getRequestDispatcher("insertColumns.jsp").forward(req, resp);
                }
                else {
                    try {
                        service.insert();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    resp.sendRedirect(resp.encodeRedirectURL("find"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  else if (action.equals("/update")) {
            String tableName = req.getParameter("tName");
            queryParameters.setTableName(tableName);
            try {
                req.setAttribute("tabledata", service.tablePresenter(tableName, ""));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("updateTable.jsp").forward(req, resp);
        }  else if (action.equals("/updateTable")) {
            queryParameters.setColumn(req.getParameter("column"));
            queryParameters.setOldValue(req.getParameter("oldValue"));
            queryParameters.setNewValue(req.getParameter("newValue"));
            try {
                service.update();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
