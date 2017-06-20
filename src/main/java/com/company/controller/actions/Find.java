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
//public class Find extends AbstractAction {
////
////    @Override
////    public boolean canProcess(String action) {
////        return "/find".equals(action);
////    }
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    @Override
//    public void process(HttpServletRequest req, HttpServletResponse resp) {
//        String tableName = req.getParameter("tName");
//        String limitOffset = req.getParameter("LO");
//        try {
//            req.setAttribute("tabledata", service.tablePresenter(tableName, limitOffset));
//            req.getRequestDispatcher("table.jsp").forward(req, resp);
//            resp.sendRedirect(resp.encodeRedirectURL("menu"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
////
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        try {
////            req.getRequestDispatcher("find.jsp").forward(req, resp);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
