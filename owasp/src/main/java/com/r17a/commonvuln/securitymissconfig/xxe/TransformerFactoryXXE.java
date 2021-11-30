package com.r17a.commonvuln.securitymissconfig.xxe;

import javax.xml.XMLConstants;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;

public class TransformerFactoryXXE extends XXE {
    public static void main(String[] args) {
        new TransformerFactoryXXE().test();
    }
    @Override
    void readNoFixXxe() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            TransformerFactory tf = TransformerFactory.newInstance();
            StreamSource source = new StreamSource(byteArrayInputStream);
            tf.newTransformer().transform(source,  new StreamResult(System.out));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    void readWithFixXxe() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Payloads.FEEDBACK.getBytes());
            TransformerFactory tf = TransformerFactory.newInstance();
            tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            StreamSource source = new StreamSource(byteArrayInputStream);
            tf.newTransformer().transform(source,  new StreamResult(System.out));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
