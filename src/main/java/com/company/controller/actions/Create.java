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
//public class Create extends AbstractAction {
//
//
//    //DELETE
//
//
////    @Override
////    public boolean canProcess(String action) {
////        return "/create".equals(action);
////    }
//    @RequestMapping(value = "/create", method = RequestMethod.GET)
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        queryParameters.setTableName(req.getParameter("tName"));
//        queryParameters.setColumnsNumber(req.getParameter("cNumber"));
//        try {
//            req.getRequestDispatcher("createColumns.jsp").forward(req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        queryParameters.setCounter(1);
//    }
////
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        try {
////            req.getRequestDispatcher("create.jsp").forward(req, resp);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
