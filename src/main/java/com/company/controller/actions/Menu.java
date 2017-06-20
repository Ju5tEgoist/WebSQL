//package com.company.controller.actions;
//
//import com.company.controller.Controller;
//import org.springframework.stereotype.Component;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import javax.servlet.http.HttpSession;
//
///**
// * Created by yulia on 16.05.17.
// */
//@Component
//public class Menu extends Controller {
//
//                 //DELETE
////    @Override
////    public boolean canProcess(String action) {
////        return "/menu".equals(action);
////    }
//
////    @Override
////    public void process(HttpServletRequest req, HttpServletResponse resp) {
////        //do nothing
////    }
//
//    @Override
//    @RequestMapping(value = "/menu", method = RequestMethod.GET)
//    protected String doGet(HttpSession httpSession, Model model) {
//        model.addAttribute("items", service.getCommandsList().keySet());
//        return "menu";
//    }
//
//    @Override
//    protected String doPost(HttpSession httpSession) {
//        return null;
//    }
//
////    @Override
////    public void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) {
////        req.setAttribute("items", service.getCommandsList().keySet());
////        try {
////            req.getRequestDispatcher("menu.jsp").forward(req, resp);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
