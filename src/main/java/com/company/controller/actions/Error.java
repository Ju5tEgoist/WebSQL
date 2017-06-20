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
//public class Error extends AbstractAction {
//
////    @Override
////    public boolean canProcess(String action) {
////        return "/error".equals(action);
////    }
//    @RequestMapping(value = "/error", method = RequestMethod.GET)
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        //do nothing
//    }
////
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        try {
////            req.getRequestDispatcher("error.jsp").forward(req, resp);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
