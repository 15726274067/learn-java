package com.zhutao.learn.core.javacore.gof.behavior.expression;

/**
 * 为语言创建解释器，通常由语言的语法和语法分析来定义。
 *
 * TerminalExpression：终结符表达式，每个终结符都需要一个 TerminalExpression。
 * Context：上下文，包含解释器之外的一些全局信息。
 *
 * 以下是一个规则检验器实现，具有 and 和 or 规则，通过规则可以构建一颗解析树，用来检验一个文本是否满足解析树定义的规则。
 * 例如一颗解析树为 D And (A Or (B C))，文本 "D A" 满足该解析树定义的规则。
 * @Author: zhutao
 * @Date: 2019-06-25 21:12
 * @Version 1.0
 */
public class Client {

    /**
     * 构建解析树
     */
    public static Expression buildInterpreterTree() {
        // Literal
        Expression terminal1 = new TerminalExpression("A");
        Expression terminal2 = new TerminalExpression("B");
        Expression terminal3 = new TerminalExpression("C");
        Expression terminal4 = new TerminalExpression("D");
        // B C
        Expression alternation1 = new OrExpression(terminal2, terminal3);
        // A Or (B C)
        Expression alternation2 = new OrExpression(terminal1, alternation1);
        // D And (A Or (B C))
        return new AndExpression(terminal4, alternation2);
    }

    public static void main(String[] args) {
        Expression define = buildInterpreterTree();
        String context1 = "D A";
        String context2 = "A B";
        System.out.println(define.interpret(context1));
        System.out.println(define.interpret(context2));
    }
}
