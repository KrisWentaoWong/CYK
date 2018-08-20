package com.company.test;

import com.company.util.ParseRule;
import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kriswong on 2018/8/19.
 */
public class ParseRuleTest {
    ParseRule parseRule = new ParseRule();
    String rule1 = "S->NP VP";
    String rule2 = "NP->she";
    String rule3 = "NP->she->he";
    String rule4 = "NP";
    @org.junit.Test
    public void parseRule() throws Exception {
        System.out.println(parseRule.parseRule(rule1));
        System.out.println(parseRule.parseRule(rule2));
        System.out.println(parseRule.parseRule(rule3));
        System.out.println(parseRule.parseRule(rule4));
    }

    @Test
    public void parseRuleWithTerminal() throws Exception {
//        parseRule.parseRuleWithTerminal(rule1);
        parseRule.parseRuleWithTerminal(rule2);
//        parseRule.parseRuleWithTerminal(rule3);
    }

    @Test
    public void parseRuleWithNonTerminal() throws Exception {
        parseRule.parseRuleWithNonTerminal(rule1);
//        parseRule.parseRuleWithNonTerminal(rule2);
//        parseRule.parseRuleWithNonTerminal(rule3);
    }

}