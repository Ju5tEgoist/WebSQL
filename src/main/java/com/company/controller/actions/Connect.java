package com.company.controller.actions;

import com.company.controller.service.Service;
import com.company.model.Main;
import com.company.model.query.parameter.QueryParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by yulia on 16.05.17.
 */
//@Component
//public class Connect extends com.company.controller.Controller {
//

    //DELETE
//
//
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        queryParameters.setDatabase(req.getParameter("dbname"));
//        queryParameters.setUserName(req.getParameter("username"));
//        queryParameters.setPassword(req.getParameter("password"));
//        try {
//            service.connect();
//            resp.sendRedirect(resp.encodeRedirectURL("menu"));
//        } catch (Exception e) {
//            req.setAttribute("message", e.getMessage());
//            try {
//                req.getRequestDispatcher("error.jsp").forward(req, resp);
//            } catch (ServletException e1) {
//                e1.printStackTrace();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }
//    }
//    @Override
//    @RequestMapping(value = "/connect", method = RequestMethod.GET)
//    public String doGet(HttpSession httpSession, Model model) {
//        return "connect";
//    }
//
//    @Override
//    @RequestMapping(value = "/connect", method = RequestMethod.POST)
//    public String doPost(HttpSession httpSession) {
//        queryParameters.setDatabase(getAttribute(httpSession,"dbname"));
//        queryParameters.setUserName(getAttribute(httpSession,"username"));
//        queryParameters.setPassword((getAttribute(httpSession,"password")));
//        try {
//            service.connect();
//            return "menu";
//        } catch (Exception e) {
//            return "error";
//        }
//    }


//    @RequestMapping(value = "/connect", method = RequestMethod.GET)
//    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
//        try {
//            req.getRequestDispatcher("connect.jsp").forward(req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
