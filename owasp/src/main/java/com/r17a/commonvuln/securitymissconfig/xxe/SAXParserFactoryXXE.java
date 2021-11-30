package com.r17a.commonvuln.securitymissconfig.xxe;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;

public class SAXParserFactoryXXE extends XXE {

    public static void main(String[] args) {
        new SAXParserFactoryXXE().test();
    }


    void readNoFixXxe() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXHandel handel = new SAXHandel();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            saxParser.parse(byteArrayInputStream, handel);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void readWithFixXxe() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            SAXParser saxParser = factory.newSAXParser();
            SAXHandel handel = new SAXHandel();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            saxParser.parse(byteArrayInputStream, handel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandel extends DefaultHandler {

    //遍历xml文件开始标签
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("sax解析开始");
    }

    //遍历xml文件结束标签
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("sax解析结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("student")) {
            System.out.println("============开始遍历=============");
            //System.out.println(attributes.getValue("rollno"));
        } else if (!qName.equals("student") && !qName.equals("class")) {
            System.out.print("节点名称:" + qName + "----");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("============结束遍历=============");
    }

    @Override
    public void characters(char ch[], int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length).trim();
        if (!value.equals("")) {
            System.out.println(value);
        }
    }
}