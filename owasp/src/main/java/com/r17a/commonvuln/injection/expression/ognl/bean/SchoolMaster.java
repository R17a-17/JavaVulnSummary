package com.r17a.commonvuln.injection.expression.ognl.bean;

public class SchoolMaster {
    String name;

    public SchoolMaster(){

    }

    public SchoolMaster(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
