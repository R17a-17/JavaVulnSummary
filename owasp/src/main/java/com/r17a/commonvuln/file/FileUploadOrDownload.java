package com.r17a.commonvuln.file;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
/**
* 模拟客户端上传、下载文件
* */
public class FileUploadOrDownload {
    public static void main(String[] args) throws IOException {
        //        String fileName = "111.png";
        String fileName = "../../../../../../../../../../../../../../../../111.png";
        FileUploadOrDownload fileUploadOrDownload = new FileUploadOrDownload();
        fileUploadOrDownload.getImg(fileName);
    }

    private void getImg(String fileName){
        try {
            // 1、模拟客户端上传文件
            // 2、或者服务器端返回文件给客户端
//            FileInputStream imgFile = this.getImgFileNoFix(fileName);
            FileInputStream imgFile = this.getImgFileWithFix(fileName);
            if(imgFile==null){
                System.out.println("File not found!");
                return;
            }

            // 1、模仿客户端下载，设置文件保存的路径和文件名  跟上面注释1对应
            // 2、或者服务器接收客户端上传的文件，设置文件保存的路径和文件名  跟上面注释2对应
            File tmp = new File("./owasp/src/main/resources/tmp", "tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(tmp);
            int len;
            byte[] bytes = new byte[1024];
            while ((len=imgFile.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
            fileOutputStream.close();
            imgFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private FileInputStream getImgFileWithFix(String fileName) {
        // 获取文件名，不包含路径（过滤路径穿越相关符号）
        fileName = FilenameUtils.getName(fileName);
        // 加白名单判断后缀
        String[] whiteList = {"png","jpg","jpeg","gif"};
        if(!FilenameUtils.isExtension(fileName.toLowerCase(), whiteList)){
            System.out.println("File extension is not allow!");
            return null;
        }
        File file = new File("./owasp/src/main/resources/imgs", fileName);
        if(!file.exists()){
            System.out.println("File not found!");
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private FileInputStream getImgFileNoFix(String fileName) {
        File file = new File("./owasp/src/main/resources/imgs", fileName);
        if(!file.exists()){
            System.out.println("File not found!");
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}
