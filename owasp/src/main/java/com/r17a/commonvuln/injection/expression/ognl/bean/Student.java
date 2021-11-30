package com.r17a.commonvuln.injection.expression.ognl.bean;

public class Student {
    String name;
    School school;

    public Student(){

    }

    public void takingClasses(String className){
        System.out.println(this.getName() + "正在上" + className + "课...");
    }

    public Student(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
