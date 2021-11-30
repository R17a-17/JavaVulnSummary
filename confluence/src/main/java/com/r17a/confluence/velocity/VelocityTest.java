package com.r17a.confluence.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.io.StringWriter;


public class VelocityTest {
    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        //加载classpath resources目录下的文件
        velocityEngine.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        VelocityContext context = new VelocityContext();
        context.put("value1", "\u0027");
        context.put("value2", null);

        // 获取模板文件传递数据完成渲染
        Template template = velocityEngine.getTemplate("velocity/velocity_test.vm");
        StringWriter stringWriter = new StringWriter();
        template.merge(context, stringWriter);
        System.out.println(stringWriter);
    }
}