package com.r17a.commonvuln.securitymissconfig.securitymanager.policy;

import java.io.*;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class TestFilePolicy {
    public static void main(String[] args) {
        String policyFileName = "E:/fileTest.policy";
        final String allowFileName = "E:/test.txt";
        // 1、首先设置好policy文件
        CreatePolicy createPolicy = new CreatePolicy();
        createPolicy.createFilePermission(policyFileName, allowFileName);
        System.setProperty("java.security.policy", "file:/" + policyFileName);
        // 2、启动 SecurityManager
        SecurityManager securityManager = new SecurityManager();
        System.setSecurityManager(securityManager);
        // 3、尝试写文件
        try {
            securityManager.checkWrite(allowFileName);
            write(new File(allowFileName));
            System.out.println("file write ok");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        // 4、用AccessController.doPrivileged赋予写文件特权
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                @Override
                public Void run() throws Exception {
                    try {
                        System.out.println("file read ok");
                        read(new File(allowFileName));
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            e.printStackTrace();
        }
    }


    private static void write(File file) throws Throwable {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("test");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File file) throws Throwable {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            FileReader fileReader = new FileReader(file);
            int len;
            char[] chars = new char[1024];
            while ((len=fileReader.read(chars))!=-1) {
                stringBuffer.append(chars,0,len);
            }
            System.out.println(stringBuffer);
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
