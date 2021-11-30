package com.r17a.commonvuln.securitymissconfig.xxe;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class SAXBuilderXXE extends XXE {
    public static void main(String[] args) {
        new SAXBuilderXXE().test();
    }

    void readNoFixXxe() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(byteArrayInputStream);
            Element element = document.getRootElement();
            List<Content> contents = element.getContent();
            for (Content content : contents) {
                System.out.println(content.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void readWithFixXxe() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            saxBuilder.setFeature("http://xml.org/sax/features/external-general-entities", false);
            saxBuilder.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            saxBuilder.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            Document document = saxBuilder.build(byteArrayInputStream);
            Element element = document.getRootElement();
            List<Content> contents = element.getContent();
            for (Content content : contents) {
                System.out.println(content.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
