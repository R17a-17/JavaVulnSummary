package test;

import java.io.IOException;
import com.alibaba.fastjson.JSON;

public class FastjsonTest {
    public static void main(String[] args) {
        POJO calc = new POJO("calc");
        String s = JSON.toJSONString(calc);
        System.out.println(s);
        POJO jsonObject = JSON.parseObject(s, POJO.class);
        System.out.println(jsonObject.toString());
    }


}

class POJO {
    public String cmd;

    POJO(){
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public POJO(String cmd) {
        this.cmd = cmd;
        try {
            Runtime.getRuntime().exec(this.cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
