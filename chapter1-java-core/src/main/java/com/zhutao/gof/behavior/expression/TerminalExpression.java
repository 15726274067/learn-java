package com.zhutao.gof.behavior.expression;

import java.util.StringTokenizer;

/**
 * @Author: zhutao
 * @Date: 2019-06-25 21:10
 * @Version 1.0
 */
public class TerminalExpression extends Expression {
    String literal = null;

    public TerminalExpression(String literal) {
        this.literal = literal;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
