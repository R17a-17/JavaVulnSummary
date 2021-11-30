package com.r17a.commonvuln.securitymissconfig.xxe;


import javax.xml.XMLConstants;
import javax.xml.transform.Result;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;

public class SAXTransformerFactoryXXE extends XXE {
    public static void main(String[] args) {
        new SAXTransformerFactoryXXE().test();
    }

    @Override
    void readNoFixXxe() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.NO_FEEDBACK_SINGLE_LINE.getBytes());
            SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            StreamSource source = new StreamSource(byteArrayInputStream);
            TransformerHandler transformerHandler = sf.newTransformerHandler(source);
            // 创建Result对象，并通过transformerHandler将目的流与其关联
            Result result = new StreamResult(System.out);
            transformerHandler.setResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void readWithFixXxe() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK_XSL.getBytes());
            SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            sf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            sf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            StreamSource source = new StreamSource(byteArrayInputStream);
            TransformerHandler transformerHandler = sf.newTransformerHandler(source);
            // 创建Result对象，并通过transformerHandler将目的流与其关联
            Result result = new StreamResult(System.out);
            transformerHandler.setResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
