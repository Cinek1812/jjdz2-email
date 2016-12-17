package com.jbd.Authorization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;


@SessionScoped
public class SessionData implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(SessionData.class);

    private boolean isLogged = false;
    private String username;
    private LocalDate loginTime;
    private String code = null;

    public boolean isLogged() {
        return isLogged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }

    public void login(String code,String username) {
        if(!code.equals("")){
            this.isLogged = true;
            this.username = username;
            this.code = code;
            //this.loginTime = loginTime;
            LOGGER.info("Log in successful for: " + getUsername());
        }
        else {
            LOGGER.error("Login Failed!");
        }

    }

    public void logout(){
        this.isLogged = false;
        this.username = "";
        this.code = null;
        LOGGER.info("Logout successful");

    }

}
