package com.r17a.commonvuln.injection.expression.ognl.bean;

public class School {
    String name;
    SchoolMaster schoolMaster;

    public School(){

    }

    public School(String name, SchoolMaster schoolMaster) {
        this.name = name;
        this.schoolMaster = schoolMaster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SchoolMaster getSchoolMaster() {
        return schoolMaster;
    }

    public void setSchoolMaster(SchoolMaster schoolMaster) {
        this.schoolMaster = schoolMaster;
    }
}
