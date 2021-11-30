package com.r17a.commonvuln.file;

import java.io.File;

public class FileDelete {
    public static void main(String[] args) {
        String fileName = "../../../../../../../../../../../../../../../../111.png";
        FileDelete fileDelete = new FileDelete();
//        fileDelete.fileDeleteNoFix(fileName);
        fileDelete.fileDeleteWithFix(fileName);
    }

    private Boolean fileDeleteNoFix(String fileName) {
        File file = new File("./owasp/src/main/resources/imgs", fileName);
        if (file.exists() && file.delete()) {
            System.out.println("Delete success!");
            return true;
        }
        System.out.println("Delete fail!");
        return false;
    }

    private boolean fileDeleteWithFix(String fileName) {
        File file = new File("./owasp/src/main/resources/imgs", fileName);
        // 获取最后一个"."所在位置
        int index = fileName.lastIndexOf(".");
        //如果使用 int index = fileName.indexOf("."); ，会获取第一个.的索引，可以用1.png.jsp绕过，修复失败
        String extension = fileName.substring(index);
        // 加白名单判断后缀
        String[] whiteList = {".png", ".jpg", ".jpeg", ".gif"};
        for (String list : whiteList) {
            if (extension.toLowerCase().equals(list)) {
                if (file.exists() && file.delete()) {
                    System.out.println("Delete success!");
                    return true;
                }
                System.out.println("Delete fail!");
                return false;
            }
        }
        System.out.println("File extension is not allow!");
        return false;

    }

}
