package com.r17a.commonvuln.cors;

import java.util.HashMap;

public class Cors {
    /**
     * 漏洞模拟
     * https://portswigger.net/web-security/cors
     * */
    public static void main(String[] args) {
        Cors response = new Cors();
        // 漏洞
        response.setResponseHeader("Access-Control-Allow-Origin", "*");
        response.setResponseHeader("Access-Control-Allow-Origin", null);
        // 白名单修复
        String[] authdomains = new String[]{"a.com.cn"};
        response.setResponseHeader("Access-Control-Allow-Origin", authdomains);
    }

    public void setResponseHeader(String header, Object value) {
        HashMap headers = new HashMap(10);
        headers.put(header, value);
    }

}
