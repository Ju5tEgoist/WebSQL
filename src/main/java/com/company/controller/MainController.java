package com.company.controller;

import com.company.controller.service.Service;
import com.company.model.SQLDatabaseConnector;
import com.company.model.query.parameter.QueryParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Model model){
        model.addAttribute("items", service.getCommandsList().keySet());
        return "menu";
    }


    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String process(HttpServletRequest req) {
        req.setAttribute("items", service.getCommandsList());
       return "help";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String noCommand(){
        return "redirect:/menu";
    }



    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public String clearGET(){
        return "clear";
    }

    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public String clearPOST(HttpSession httpSession, HttpServletRequest request)  {
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

    @RequestMapping(value = "/connect", params = {"connect"}, method = RequestMethod.GET)
    public String connectGET(HttpSession session){
        if (getManager(session) == null) {
            return "connect";
        } else {
            return "menu";
        }
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String connectPOST(HttpSession session, Model model, HttpServletRequest request) {
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
    public String createGET(){
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPOST(HttpSession httpSession, HttpServletRequest request){
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
    public String createColumnsPOST(HttpSession httpSession, HttpServletRequest request) {
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
    public String deleteGET(){
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePOST(HttpServletRequest request) throws SQLException {
        String tableName = request.getParameter("tName");
        queryParameters.setTableName(tableName);
        request.setAttribute("items", service.tablePresenter(queryParameters.getTableName(),
                ""));
        return "deleteValue";
    }

    @RequestMapping(value = "/deleteValue", method = RequestMethod.POST)
    public String deleteValuePOST(HttpServletRequest request) {
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
    public String dropGET(){
        return "drop";
    }

    @RequestMapping(value = "/drop", method = RequestMethod.POST)
    public String dropPOST(HttpServletRequest request){
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
    public String errorGET(){
        return "error";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGET(){
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePOST(HttpServletRequest request) throws SQLException {
        String tableName = request.getParameter("tName");
        queryParameters.setTableName(tableName);
        return "updateValue";
    }

    @RequestMapping(value = "/updateValue", method = RequestMethod.POST)
    public String updateValuePOST(HttpServletRequest request) {
        try {
        request.setAttribute("items", service.tablePresenter(queryParameters.getTableName(), ""));
        queryParameters.setColumn(request.getParameter("column"));
        queryParameters.setOldValue(request.getParameter("oldValue"));
        queryParameters.setNewValue(request.getParameter("newValue"));
        service.update();
        return "redirect:" + "/menu";
        } catch (Exception e) {
            return "redirect:" + "/error";
        }
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findGET(){
        return "find";
    }

    //TODO: fix "limit/offset"
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findPOST(HttpServletRequest request){
        String tableName = request.getParameter("tName");
        String limOff = request.getParameter("LO");
        try {
            request.setAttribute("items", service.tablePresenter(tableName, limOff));
            return "table";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertGET(){
        return "insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertPOST(HttpSession httpSession, HttpServletRequest request){
        String tableName = request.getParameter("tName");
        httpSession.setAttribute("tName", tableName);
        queryParameters.setTableName(tableName);
        queryParameters.setCounter(1);
        try {
            return "insertColumns";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "/insertColumns", method = RequestMethod.POST)
    public String insertColumnsPOST(HttpServletRequest request) throws SQLException {
        if(queryParameters.getCounter() <= service.getInsertColumnsNumber(queryParameters)){
            try {
                queryParameters.addValue(request.getParameter("value"));
                //TODO: fix==>
                return "insertColumns";
            } catch (Exception e) {
                return "error";
            }
        }
        else {
            try {
                service.insert();
                return "redirect:" +"/menu";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "redirect:" + "/error";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listGET(HttpServletRequest request) throws SQLException {
        request.setAttribute("items", service.getList());
        return "list";
    }
}
