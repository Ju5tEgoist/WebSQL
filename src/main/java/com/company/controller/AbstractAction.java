package com.company.controller;

import com.company.controller.query.parameter.QueryParameters;
import com.company.controller.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yulia on 16.05.17.
 */
public abstract class AbstractAction implements Action {

    protected QueryParameters queryParameters;
    protected Service service;

    @Autowired
    public void setQueryParameters(QueryParameters queryParameters) {
        this.queryParameters = queryParameters;
    }

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }
}
