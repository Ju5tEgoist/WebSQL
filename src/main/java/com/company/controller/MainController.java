package com.company.controller;

import com.company.controller.service.Service;
import com.company.model.SQLDatabaseConnector;
import com.company.model.query.parameter.QueryParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by yulia on 23.05.17.
 */
@Controller
public class MainController {

    @Autowired
    Service service;

    @Autowired
    QueryParameters queryParameters;


    private SQLDatabaseConnector getManager(HttpSession session) {
        return (SQLDatabaseConnector) session.getAttribute("db_manager");
    }

    private String getAttribute(HttpSession httpSession, String value){
        return (String) httpSession.getAttribute(value);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Model model) throws ServletException, IOException {
        model.addAttribute("items", service.getCommandsList().keySet());
        return "menu";
    }


    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String process(HttpServletRequest req) {
        req.setAttribute("items", service.getCommandsList());
       return "help";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String noCommand() throws ServletException, IOException {
        return "redirect:/menu";
    }



    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public String clearGET() throws ServletException, IOException {
        return "clear";
    }

    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public String clearPOST(HttpSession httpSession, HttpServletRequest request) throws ServletException, IOException {
        String tableName = request.getParameter("tName");
        httpSession.setAttribute("tName", tableName);
        queryParameters.setTableName(tableName);
        try {
            service.clearTable();
            return "redirect:/menu";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String connectGET(HttpSession session) throws ServletException, IOException {
        if (getManager(session) == null) {
            return "connect";
        } else {
            return "menu";
        }
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String connectPOST(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String dbName = request.getParameter("dbName");
            session.setAttribute("dbName", dbName);
            String userName = request.getParameter("userName");
            session.setAttribute("userName", userName);
            //TODO encryption
            String password = request.getParameter("password");
            session.setAttribute("password", password);
            service.connect(dbName, userName, password);
            return "redirect:" + "/menu";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createGET() throws ServletException, IOException {
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPOST(HttpSession httpSession, HttpServletRequest request) throws ServletException, IOException {
        String tableName = request.getParameter("tName");
        String columnsNumber = request.getParameter("cNumber");
        httpSession.setAttribute("tName", tableName);
        httpSession.setAttribute("cNumber", columnsNumber);
        queryParameters.setTableName(tableName);
        queryParameters.setColumnsNumber(columnsNumber);
        queryParameters.setCounter(1);
        try {
            return "createColumns";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "/createColumns", method = RequestMethod.POST)
    public String createColumnsPOST(HttpSession httpSession, HttpServletRequest request) throws ServletException, IOException {
        String columnName = request.getParameter("cName");
        httpSession.setAttribute("cName", columnName);
        queryParameters.addName(columnName);
        if(queryParameters.getCounter() < queryParameters.getColumnsNumber()){
            try {
                return "createColumns";
            } catch (Exception e) {
                return "error";
            }
        }
        else {
            try {
                service.createTable();
                return "redirect:" +"/menu";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "redirect:" + "/error";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGET() throws ServletException, IOException {
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePOST(HttpServletRequest request) throws ServletException, IOException, SQLException {
        String tableName = request.getParameter("tName");
        queryParameters.setTableName(tableName);
        request.setAttribute("items", service.tablePresenter(queryParameters.getTableName(),
                ""));
        return "deleteValue";
    }

    @RequestMapping(value = "/deleteValue", method = RequestMethod.POST)
    public String deleteValuePOST(HttpServletRequest request) throws ServletException, IOException {
        try {
            queryParameters.setColumn(request.getParameter("columnName"));
            queryParameters.setValue(request.getParameter("value"));
            service.delete();
            return "redirect:" + "/menu";
        } catch (Exception e) {
            return "redirect:" + "/error";
        }
    }

    @RequestMapping(value = "/drop", method = RequestMethod.GET)
    public String dropGET() throws ServletException, IOException {
        return "drop";
    }

    @RequestMapping(value = "/drop", method = RequestMethod.POST)
    public String dropPOST(HttpServletRequest request) throws ServletException, IOException {
        String tableName = request.getParameter("tName");
        queryParameters.setTableName(tableName);
        try {
            service.dropTable();
           return "redirect:" + "/menu";
        } catch (Exception e) {
            return "redirect:" + "/error";
        }
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorGET() throws ServletException, IOException {
        return "error";
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGET() throws ServletException, IOException {
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePOST(HttpServletRequest request) throws ServletException, IOException, SQLException {
        String tableName = request.getParameter("tName");
        queryParameters.setTableName(tableName);
        return "updateValue";
    }

    @RequestMapping(value = "/updateValue", method = RequestMethod.POST)
    public String updateValuePOST(HttpServletRequest request) throws SQLException {
        request.setAttribute("items", service.tablePresenter(queryParameters.getTableName(), ""));
        queryParameters.setColumn(request.getParameter("column"));
        queryParameters.setOldValue(request.getParameter("oldValue"));
        queryParameters.setNewValue(request.getParameter("newValue"));
        try {
            service.update();
            return "redirect:" + "/menu";
        } catch (Exception e) {
            return "error";
        }
    }

}
