package com.r17a.commonvuln.securitymissconfig.securitymanager.policy;

import java.io.*;

public class CreatePolicy {
    public static void main(String[] args) {
        CreatePolicy createPolicy = new CreatePolicy();
        createPolicy.createFilePermission("E:/myTest.policy", "E:\\test.txt");
    }

    /**
     * 在指定文件下生成一个policy文件，允许某个文件的读写
     *
     * @param policyFileName 指定配置文件保存位置
     * @param allowFileName 指定可读写文件
     */
    public void createFilePermission(String policyFileName, String allowFileName) {
        allowFileName = allowFileName.replace("\\", "/");
        String policyContent = "grant {\n" +
                "    permission java.io.FilePermission \"" + allowFileName + "\",\"read,write\";\n" +
                "};";
        try {
            FileWriter fileWriter = new FileWriter(policyFileName);
            fileWriter.write(policyContent);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据授权内容在指定文件下生成一个policy文件
     *
     * @param permission  指定授权内容
     * @param policyFileName 指定配置文件保存位置
     */
    public void createAnyPermission(String permission, String policyFileName){
        String policyContent = "grant {\n    " + permission +"\n" +"\n};";
        try {
            FileWriter fileWriter = new FileWriter(policyFileName);
            fileWriter.write(permission);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
