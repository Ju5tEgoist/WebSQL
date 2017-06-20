//package com.company.controller;
//
//import com.company.controller.service.Service;
//import com.company.model.query.parameter.QueryParameters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//
//import javax.servlet.http.HttpSession;
//
///**
// * Created by yulia on 24.05.17.
// */
//@org.springframework.stereotype.Controller
//public abstract class Controller {
//
//    @Autowired
//    protected QueryParameters queryParameters;
//
//    @Autowired
//    protected Service service;
//
//    protected abstract String doGet(HttpSession httpSession, Model model);
//    protected abstract String doPost(HttpSession httpSession);
//
//    public String getAttribute(HttpSession httpSession, String value){
//        return (String) httpSession.getAttribute(value);
//    }
//}
