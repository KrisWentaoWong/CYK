package com.company.cnf;

import com.company.util.ParseRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kriswong on 2018/8/19.
 * 乔姆斯基范式
 */
public class CNF {
    List<String> originalRules;
    List<String> rules;
    List<RuleWithNonTerminal> ruleWithNonTerminals;
    List<RuleWithTerminal> ruleWithTerminals;

    public CNF(){
        originalRules = new ArrayList<>();
        rules = new ArrayList<>();
        ruleWithNonTerminals = new ArrayList<>();
        ruleWithTerminals = new ArrayList<>();
    }

    //对CNF进行预处理，划分为产生非终结符的规则集和产生终结符的规则集
    public void preProcessRules(){
        //先将复合产生式解析为单一产生式
        splitRule();

        ParseRule parseRule = new ParseRule();
        //逐条解析规则
        for(int i=0;i< rules.size();++i){
            String rule = rules.get(i);
            if("NonTerminalRule".equals(parseRule.parseRule(rule))){
                //如果规则是产生非终结符的规则
                RuleWithNonTerminal ruleWithNonTerminal = parseRule.parseRuleWithNonTerminal(rule);
                ruleWithNonTerminals.add(ruleWithNonTerminal);
            }else if("TerminalRule".equals(parseRule.parseRule(rule))){
                //如果规则是产生终结符的规则
                RuleWithTerminal ruleWithTerminal = parseRule.parseRuleWithTerminal(rule);
                ruleWithTerminals.add(ruleWithTerminal);
            }else{

            }
        }
    }

    public void splitRule(){
        rules = new ArrayList<>();
        for(int i=0;i<originalRules.size();++i){
            String rule = originalRules.get(i);
            //对于由|分隔的复合产生式，|的左部是完整的一条规则，有部需要跟产生符号拼接组成规则
            if(rule.contains("|")){
                String[] rulesplit = rule.split("\\|");
                String firstRule = rulesplit[0];
                rules.add(firstRule);
                String[] firstRuleContents = rulesplit[0].split("->");
                String leftCommon = firstRuleContents[0];
                for(int j=1;j<rulesplit.length;++j){
                    String remainRule = leftCommon + "->" + rulesplit[j];
                    rules.add(remainRule);
                }
            }else{
                rules.add(rule);
            }
        }
    }

    //获得cnf的开始符号
    public String getStartSymbol(){
        return ruleWithNonTerminals.get(0).getLeftVariable().getNonterminalVariable();
    }

    public List<String> getOriginalRules() {
        return originalRules;
    }

    public void setOriginalRules(List<String> originalRules) {
        this.originalRules = originalRules;
    }

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public List<RuleWithNonTerminal> getRuleWithNonTerminals() {
        return ruleWithNonTerminals;
    }

    public void setRuleWithNonTerminals(List<RuleWithNonTerminal> ruleWithNonTerminals) {
        this.ruleWithNonTerminals = ruleWithNonTerminals;
    }

    public List<RuleWithTerminal> getRuleWithTerminals() {
        return ruleWithTerminals;
    }

    public void setRuleWithTerminals(List<RuleWithTerminal> ruleWithTerminals) {
        this.ruleWithTerminals = ruleWithTerminals;
    }
}
