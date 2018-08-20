package com.company.util;

import com.company.cnf.NonTerminal;
import com.company.cnf.RuleWithNonTerminal;
import com.company.cnf.RuleWithTerminal;
import com.company.cnf.Terminal;

/**
 * Created by kriswong on 2018/8/19.
 * 解析规则
 */
public class ParseRule {

    //区分推导出终结符的规则还是推导出非终结符的规则
    public String parseRule(String rule){
        String leftRight[] = rule.split("->");
        if(leftRight.length != 2){
            System.out.println("异常规则！");
            return "异常规则！";
        }
        else{
            if(leftRight[1].contains(" ")){
                return "NonTerminalRule";
            }else{
                return "TerminalRule";
            }
        }
    }

    //解析终结符规则
    public RuleWithTerminal parseRuleWithTerminal(String rule){
        if(parseRule(rule) != "TerminalRule"){
            System.out.println("解析异常！该条规则不是推导出终结符的规则！");
            return null;
        }else {
            String leftRight[] = rule.split("->");

            RuleWithTerminal ruleWithTerminal = new RuleWithTerminal();
            NonTerminal leftVariable = new NonTerminal();
            Terminal rightVairable = new Terminal();

            //给规则左边和右边的变量赋值
            leftVariable.setNonterminalVariable(leftRight[0]);
            rightVairable.setTerminalVariable(leftRight[1]);

            ruleWithTerminal.setLeftVariable(leftVariable);
            ruleWithTerminal.setRightVariable(rightVairable);

            return ruleWithTerminal;
        }
    }

    //解析非终结符规则
    public RuleWithNonTerminal parseRuleWithNonTerminal(String rule){
        if(parseRule(rule) != "NonTerminalRule"){
            System.out.println("解析异常！该条规则不是推导出非终结符的规则！");
            return null;
        }else {
            String leftRight[] = rule.split("->");

            RuleWithNonTerminal ruleWithNonTerminal = new RuleWithNonTerminal();
            NonTerminal leftVariable = new NonTerminal();
            NonTerminal rightVairable1 = new NonTerminal();
            NonTerminal rightVairable2 = new NonTerminal();

            leftVariable.setNonterminalVariable(leftRight[0]);

            //对于右边的变量，需要根据空格再次拆分
            String right[] = leftRight[1].split(" ");
            rightVairable1.setNonterminalVariable(right[0]);
            rightVairable2.setNonterminalVariable(right[1]);

            ruleWithNonTerminal.setLeftVariable(leftVariable);
            ruleWithNonTerminal.setRightVariable1(rightVairable1);
            ruleWithNonTerminal.setRightVariable2(rightVairable2);

            return ruleWithNonTerminal;
        }
    }
}
