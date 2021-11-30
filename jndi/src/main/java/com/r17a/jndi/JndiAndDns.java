package com.r17a.jndi;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Properties;

public class JndiAndDns {
    public static void main(String[] args) {
        // 创建环境变量
        Properties env = new Properties();
        // JNDI初始化工厂类
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
        // JNDI提供服务的URL
        env.put(Context.PROVIDER_URL, "dns://8.8.8.8");
        try {
            // 创建JNDI目录服务对象
            DirContext context = new InitialDirContext(env);

            // 获取DNS解析记录测试
            Attributes attrs1 = context.getAttributes("baidu.com", new String[]{"A"});
            Attributes attrs2 = context.getAttributes("qq.com", new String[]{"A"});

            System.out.println(attrs1);
            System.out.println(attrs2);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}