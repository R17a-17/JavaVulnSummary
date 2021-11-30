package com.r17a.commonvuln.ssrf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Ssrf {
    public static void main(String[] args) {
        Ssrf ssrf = new Ssrf();
//        ssrf.requestByURLConnection("http://www.baidu.com");
        ssrf.requestByURLConnection("file:///E:/111.txt");
    }

    /**
     * URLConnection支持的协议：file ftp mailto http https jar netdoc gopher
     * gopher仅在java8以前支持，并且Java7高版本对gopher有限制
     */
    private void requestByURLConnection(String url) {
//        url = "file:///E:/111.txt";
//        url = "http://www.baidu.com"
        try {
            if (this.urlFilterByWhiteList(url).equals("")){
                return;
            }

            String htmlContent;
            URL u = new URL(url);   //实例化url的对象
            URLConnection urlConnection = u.openConnection();//打开一个URL连接，并运行客户端访问资源。
//            HttpURLConnection urlConnection1 = (HttpURLConnection) urlConnection;  //转成HttpURLConnection
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));//获取url中的资源
            StringBuffer html = new StringBuffer();
            while ((htmlContent = bufferedReader.readLine()) != null) {
                html.append(htmlContent);
            }
            bufferedReader.close();
            System.out.println(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 过滤url，增加白名单校验
     */
    private String urlFilterByWhiteList(String url) {
        String[] whiteProtocolList = {"http://", "https://"};
        String[] whiteUrlList = {"http://enable.com/","http://enable1.com/"};
        boolean protocolFlag = false;
        boolean urlFlag = false;

        for (String list : whiteProtocolList) {
            if (url.toLowerCase().contains(list) && url.toLowerCase().indexOf(list) == 0) {
                protocolFlag = true;
                break;
            }
        }
        if(!protocolFlag){
            return "";
        }

        for (String list : whiteUrlList) {
            if (url.toLowerCase().contains(list) && url.toLowerCase().indexOf(list) == 0) {
                urlFlag = true;
                break;
            }
        }
        if(!urlFlag){
            return "";
        }

        return url;
    }

    /**
     * 过滤url，增加黑名单校验
     * 黑名单校验存在绕过风险
     */
    private String urlFilterByBlackList(String url) {
        String[] blackProtocolList = {"file", "ftp", "mailto", "jar", "netdoc", "gopher"};
        String[] blackUrlList = {"192.168", "172.", "10.","169.254"};
        boolean protocolFlag = false;
        boolean urlFlag = false;

        for (String list : blackProtocolList) {
            if (url.toLowerCase().contains(list) && url.toLowerCase().indexOf(list) == 0) {
                protocolFlag = true;
                break;
            }
        }
        if(protocolFlag){
            return "";
        }

        for (String list : blackUrlList) {
            if (url.toLowerCase().contains(list) && url.toLowerCase().indexOf(list) == 0) {
                urlFlag = true;
                break;
            }
        }
        if(urlFlag){
            return "";
        }

        return url;
    }

}
