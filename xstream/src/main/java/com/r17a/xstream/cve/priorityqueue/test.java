package com.r17a.xstream.cve.priorityqueue;

public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        String xml = "<hudson.model.ListView>\n" +
                "<name>test-view</name>\n" +
                "<description>用于测试的视图1111</description>\n" +
                "<filterExecutors>false</filterExecutors>\n" +
                "<filterQueue>false</filterQueue>\n" +
                "<properties class=\"hudson.model.View$PropertyList\"/>\n" +
                "<jobNames>\n" +
                "<comparator class=\"hudson.util.CaseInsensitiveComparator\"/>\n" +
                "</jobNames>\n" +
                "<jobFilters/>\n" +
                "<columns>\n" +
                "<hudson.views.StatusColumn/>\n" +
                "<hudson.views.WeatherColumn/>\n" +
                "<hudson.views.JobColumn/>\n" +
                "<hudson.views.LastSuccessColumn/>\n" +
                "<hudson.views.LastFailureColumn/>\n" +
                "<hudson.views.LastDurationColumn/>\n" +
                "<hudson.views.BuildButtonColumn/>\n" +
                "<hudson.plugins.favorite.column.FavoriteColumn plugin=\"favorite@2.3.2\"/>\n" +
                "</columns>\n" +
                "<recurse>false</recurse>\n" +
                "</hudson.model.ListView>";
        System.out.println(xml);
    }
}
