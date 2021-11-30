package com.r17a.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 本实验代码参考vulhub
 * TODO config tomcat
 * */
public class IndexAction  extends ActionSupport {

    private String id;


    public String changeId(){
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
