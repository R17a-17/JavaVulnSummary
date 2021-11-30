package com.r17a.commonvuln.securitymissconfig.xxe;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.ByteArrayInputStream;

public class SAXReadXXE extends XXE {
    public static void main(String[] args) {
        new SAXReadXXE().test();
    }

    @Override
    void readNoFixXxe() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(byteArrayInputStream);
            XMLWriter xmlWriter = new XMLWriter(System.out);
            xmlWriter.write(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void readWithFixXxe() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            SAXReader saxReader = new SAXReader();
            saxReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            saxReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            saxReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            Document doc = saxReader.read(byteArrayInputStream);
            XMLWriter xmlWriter = new XMLWriter(System.out);
            xmlWriter.write(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
