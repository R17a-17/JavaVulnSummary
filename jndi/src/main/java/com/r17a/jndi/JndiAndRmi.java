package com.r17a.jndi;

import com.r17a.jndi.rmi.Calc;
import com.r17a.jndi.rmi.ICalc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Hashtable;

public class JndiAndRmi {
    public static void main(String[] args) {
        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test1(){
        String uri = "rmi://localhost:1099/calculate";
        try {
            Context ctx = new InitialContext();
            ICalc icalc = (ICalc) ctx.lookup(uri);
            icalc.calc();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2() throws NamingException, RemoteException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL,"rmi://127.0.0.1:1099");
        Context ctx = new InitialContext(env);

        //将名称refObj与一个对象绑定，这里底层也是调用的rmi的registry去绑定
        ctx.bind("refObj", new Calc());

        //通过名称查找对象
        ctx.lookup("refObj");
    }
}
