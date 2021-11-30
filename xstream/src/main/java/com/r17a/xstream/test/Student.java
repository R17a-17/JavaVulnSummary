package com.r17a.xstream.test;

import java.io.IOException;
import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private School school;

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        System.out.println("XML反序列化");
    }
    private void writeObject(java.io.ObjectOutputStream s) throws IOException, ClassNotFoundException {
        s.defaultWriteObject();
        System.out.println("XML序列化");
    }
}
