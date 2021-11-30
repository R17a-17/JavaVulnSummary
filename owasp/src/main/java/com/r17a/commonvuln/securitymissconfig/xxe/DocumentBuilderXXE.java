package com.r17a.commonvuln.securitymissconfig.xxe;

import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class DocumentBuilderXXE extends XXE{

    public static void main(String[] args) {
        new DocumentBuilderXXE().test();
    }


    void readNoFixXxe() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            Document d = documentBuilder.parse(byteArrayInputStream);
            System.out.println(d.getDocumentElement().getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void readWithFixXxe() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            documentBuilderFactory.setAttribute(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            Document d = documentBuilder.parse(byteArrayInputStream);
            System.out.println(d.getDocumentElement().getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
