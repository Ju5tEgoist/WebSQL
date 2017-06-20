//package com.company.controller.actions;
//
//import com.company.controller.AbstractAction;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by yulia on 16.05.17.
// */
//@Component
//public class CreateColumns extends AbstractAction {
////
////    @Override
////    public boolean canProcess(String action) {
////        return "/createColumns".equals(action);
////    }
//    @RequestMapping(value = "/createColumns", method = RequestMethod.GET)
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        String columnName = req.getParameter("cName");
//        queryParameters.setColumn(columnName);
//        queryParameters.addName(columnName);
//        if(queryParameters.getCounter() < queryParameters.getColumnsNumber()){
//            try {
//                req.getRequestDispatcher("createColumns.jsp").forward(req, resp);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }         }
//        else {
//            try {
//                service.createTable();
//                resp.sendRedirect(resp.encodeRedirectURL("menu"));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        //do nothing
////    }
//}
