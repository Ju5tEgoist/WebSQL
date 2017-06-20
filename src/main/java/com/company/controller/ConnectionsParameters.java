package com.company.controller;

import org.springframework.stereotype.Component;

/**
 * Created by yulia on 13.06.17.
 */
@Component
public class ConnectionsParameters {

    private String userName;
    private String password;
    private String dbName;
    private String fromPage;

    public ConnectionsParameters(){

    }

    public ConnectionsParameters(String page){
        this.fromPage = page;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getFromPage() {
        return fromPage;
    }

    public void setFromPage(String fromPage) {
        this.fromPage = fromPage;
    }
}
