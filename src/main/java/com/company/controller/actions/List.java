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
//public class List extends AbstractAction {
//
////    @Override
////    public boolean canProcess(String action) {
////        return "/list".equals(action);
////    }
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        //do nothing
//    }
////
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        try {
////            req.setAttribute("items", service.getList());
////            req.getRequestDispatcher("list.jsp").forward(req, resp);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////    }
//}
