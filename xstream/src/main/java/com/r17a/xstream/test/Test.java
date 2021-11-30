package com.r17a.xstream.test;

import com.thoughtworks.xstream.XStream;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        XStream xStream = new XStream();
        Student people = new Student("xiaoming", 25, new School("北京大学", 500));
        String xml = xStream.toXML(people);
        System.out.println(xml);
        Student object = (Student) xStream.fromXML(xml);

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return "这里是代理方法";
            }
        };
        // proxy必须以代理类的接口作为类型，否则会报错
        TestInterface proxy = (TestInterface) Proxy.newProxyInstance(ImpTest.class.getClassLoader(), ImpTest.class.getInterfaces(), handler);
        String proxyStr = xStream.toXML(proxy);
        System.out.println(proxyStr);
//        xStream.fromXML(proxyStr);

    }
}

interface TestInterface {
    public String test();

    public String test1(String a);
}

class ImpTest implements TestInterface {

    @Override
    public String test() {
        return "这里是被代理类的方法";
    }

    @Override
    public String test1(String a) {
        return "这里是被代理类的方法1111" + a;
    }
}