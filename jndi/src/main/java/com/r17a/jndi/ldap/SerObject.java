package com.r17a.jndi.ldap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerObject {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\ser.txt"));
        CalcTest CalcTest = new CalcTest();
        objectOutputStream.writeObject(CalcTest);
    }
}