package com.r17a.jndi.ldap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

public class LdapSerClient {
    public static void main(String[] args) throws NamingException, IOException {
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        Context ctx = new InitialContext();
        CalcTest object = (CalcTest) ctx.lookup("ldap://127.0.0.1:1389/cn=foo,dc=example,dc=com");
        System.out.println(object.toString());
        object.calc();
    }
}
