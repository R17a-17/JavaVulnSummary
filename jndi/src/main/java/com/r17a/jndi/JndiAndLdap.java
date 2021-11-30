package com.r17a.jndi;

import com.r17a.jndi.ldap.CalcTest;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.io.IOException;
import java.util.Hashtable;

public class JndiAndLdap {
    public static void main(String[] args) throws NamingException, IOException {
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:1389");

        DirContext ctx = new InitialDirContext(env);

        CalcTest local_obj = (CalcTest) ctx.lookup("cn=foo,dc=example,dc=com");
        System.out.println(local_obj.toString());
        local_obj.calc();
    }
}
