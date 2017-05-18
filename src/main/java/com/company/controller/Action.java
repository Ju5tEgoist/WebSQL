package com.company.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yulia on 16.05.17.
 */
public interface Action {
    boolean canProcess(String action);
    void process(HttpServletRequest req, HttpServletResponse resp);
    void forwardToJsp(HttpServletRequest req, HttpServletResponse resp);
}
