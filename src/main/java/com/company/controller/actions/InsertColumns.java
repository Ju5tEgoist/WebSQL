//package com.company.controller.actions;
//
//import com.company.controller.AbstractAction;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.sql.SQLException;
//
///**
// * Created by yulia on 16.05.17.
// */
//@Component
//public class InsertColumns extends AbstractAction {
//
////    @Override
////    public boolean canProcess(String action) {
////        return "/insertColumns".equals(action);
////    }
//    @RequestMapping(value = "/insertColumns", method = RequestMethod.GET)
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        String value = req.getParameter("value");
//        queryParameters.addValue(value);
//        try {
//            if(queryParameters.getCounter() < service.getInsertColumnsNumber(queryParameters)){
//                req.getRequestDispatcher("insertColumns.jsp").forward(req, resp);
//            }
//            else {
//                try {
//                    service.insert();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                resp.sendRedirect(resp.encodeRedirectURL("find"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        //do nothing
////    }
//}
