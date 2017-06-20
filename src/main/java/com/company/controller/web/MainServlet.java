//package com.company.controller.web;
//
//import com.company.controller.ActionManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by yulia on 03.04.17.
// */
//public class MainServlet extends HttpServlet {
//
////    @Autowired
////    ActionManager actionManager;
////
////    @Override
////    public void init(ServletConfig config) throws ServletException {
////        super.init(config);
////        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
////                config.getServletContext());
////
////    }
////
////    @Override
////    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String action = getAction(req);
////        actionManager.getAction(action).forwardToJsp(req, resp);
////    }
////
////    private String getAction(HttpServletRequest req) {
////        String requestURI = req.getRequestURI();
////        String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
////        char[] c = action.toCharArray();
////        String resultAction = "";
////        for (int i = 0; i < c.length; i++) {
////            if((c[i] >= 'a' && c[i] <= 'z') || c[i] == '/'){
////                resultAction+=c[i];
////            } else {
////                return resultAction;
////            }
////        }
////        return resultAction;
////    }
////
////    @Override
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String action = getAction(req);
////        actionManager.getAction(action).process(req, resp);
////    }
//}
