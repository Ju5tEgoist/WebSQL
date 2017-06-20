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
//public class Update extends AbstractAction {
//
////    @Override
////    public boolean canProcess(String action) {
////        return "/update".equals(action);
////    }
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        String tableName = req.getParameter("tName");
//        queryParameters.setTableName(tableName);
//        try {
//            req.setAttribute("tabledata", service.tablePresenter(tableName, ""));
//            req.getRequestDispatcher("updateValue.jsp").forward(req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        try {
////            req.getRequestDispatcher("update.jsp").forward(req, resp);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
