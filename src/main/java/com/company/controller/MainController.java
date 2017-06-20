package com.company.controller;

import com.company.controller.service.Service;
import com.company.model.SQLDatabaseConnector;
import com.company.model.query.parameter.QueryParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by yulia on 23.05.17.
 */
@Controller
public class MainController {

    @Autowired
    Service service;

    @Autowired
    QueryParameters queryParameters;

    @Autowired
    ConnectionsParameters connectionsParameters;

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
    public String process(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("items", service.getCommandsList());
       return "help";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String noCommand() throws ServletException, IOException {
        return "redirect:/menu";
    }



    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public String clearGET(HttpSession httpSession) throws ServletException, IOException {
        String tableName = getAttribute(httpSession,"tName");
        queryParameters.setTableName(tableName);
        return "clear";
    }

    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public String clearPOST() throws ServletException, IOException {
        try {
            service.clearTable();
            return "menu";
        } catch (Exception e) {
            return "error";
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
            service.connect(dbName,userName, password);
            return "redirect:" + "/menu";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createGET(HttpSession httpSession) throws ServletException, IOException {
        queryParameters.setTableName(getAttribute(httpSession,"tName"));
        queryParameters.setColumnsNumber(getAttribute(httpSession,"cNumber"));
        queryParameters.setCounter(1);
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPOST() throws ServletException, IOException {
        try {
            return "createColumns";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "/createColumns", method = RequestMethod.GET)
    public String createColumnsGET(HttpSession httpSession) throws ServletException, IOException {
        queryParameters.setTableName(getAttribute(httpSession,"tName"));
        queryParameters.setColumnsNumber(getAttribute(httpSession,"cNumber"));
        queryParameters.setCounter(1);
        return "create";
    }

    @RequestMapping(value = "/createColumns", method = RequestMethod.POST)
    public String createColumnsPOST() throws ServletException, IOException {
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
                return "menu";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGET(HttpSession httpSession) throws ServletException, IOException {
        String tableName = getAttribute(httpSession,"tName");
        queryParameters.setTableName(tableName);
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePOST(Model model) throws ServletException, IOException {
        try {
            model.addAttribute("tabledata", service.tablePresenter(queryParameters.getTableName(),
                    ""));
            return "delete";
        } catch (Exception e) {
            return "error";
        }

    }

    @RequestMapping(value = "/drop", method = RequestMethod.GET)
    public String dropGET(HttpSession httpSession) throws ServletException, IOException {
        String tableName = getAttribute(httpSession,"tName");
        queryParameters.setTableName(tableName);
        return "drop";
    }

    @RequestMapping(value = "/drop", method = RequestMethod.POST)
    public String dropPOST(Model model) throws ServletException, IOException {
        try {
            service.dropTable();
           return "menu";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorGET(HttpSession httpSession) throws ServletException, IOException {
        return "error";
    }
}
