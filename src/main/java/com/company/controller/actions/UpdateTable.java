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
//public class UpdateTable extends AbstractAction {
//
////    @Override
////    public boolean canProcess(String action) {
////        return "/updateTable".equals(action);
////    }
//    @RequestMapping(value = "/updateTable", method = RequestMethod.GET)
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        queryParameters.setColumn(req.getParameter("column"));
//        queryParameters.setOldValue(req.getParameter("oldValue"));
//        queryParameters.setNewValue(req.getParameter("newValue"));
//        try {
//            service.update();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        //do nothing
////    }
//}
