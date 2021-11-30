package com.r17a.commonvuln.injection.command;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public class RuntimeCmdInject {
    public static void main(String[] args) {
        RuntimeCmdInject runtimeCmdInject = new RuntimeCmdInject();
//        runtimeCmdInject.cmdNoFix("ipconfig /all");
        runtimeCmdInject.cmdArrayNoFix("127.0.0.1&echo 123321");
    }

    private void cmdNoFix(String cmd) {
        try {
            Process exec = Runtime.getRuntime().exec(cmd);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(exec.getInputStream());
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                System.out.write(bytes, 0, len);
            }
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void cmdArrayNoFix(String ip) {
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"cmd", "/k", "ping " + ip});
            BufferedInputStream bufferedInputStream = new BufferedInputStream(exec.getInputStream());
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                System.out.write(bytes, 0, len);
            }
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void cmdWithFix(String ip) {
        try {
            // 特殊字符检查
            String[] blackChar = {"&", "|", ";"};
            for (String s : blackChar) {
                if (ip.contains(s)) {
                    return;
                }
            }
            // 正则匹配IP或者域名
            String pattern = "(^\\d+(\\.\\d+){2}\\.\\d+$)|([a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?)";
            boolean ismatch = Pattern.matches(pattern, ip);
            if(!ismatch){
                return;
            }
            Process exec = Runtime.getRuntime().exec(new String[]{"ping", ip});
            BufferedInputStream bufferedInputStream = new BufferedInputStream(exec.getInputStream());
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                System.out.write(bytes, 0, len);
            }
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
