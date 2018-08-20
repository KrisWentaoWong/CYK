package com.company.cnf;

/**
 * Created by kriswong on 2018/8/19.
 * 推导出非终结符的规则，形如A->BC
 */
public class RuleWithNonTerminal {
    private NonTerminal leftVariable;
    private NonTerminal rightVariable1;
    private NonTerminal rightVariable2;

    public String toString() {
        return leftVariable.toString()+"->"+rightVariable1.toString()+" "+rightVariable2.toString();
    }

    public NonTerminal getLeftVariable() {
        return leftVariable;
    }

    public void setLeftVariable(NonTerminal leftVariable) {
        this.leftVariable = leftVariable;
    }

    public NonTerminal getRightVariable1() {
        return rightVariable1;
    }

    public void setRightVariable1(NonTerminal rightVariable1) {
        this.rightVariable1 = rightVariable1;
    }

    public NonTerminal getRightVariable2() {
        return rightVariable2;
    }

    public void setRightVariable2(NonTerminal rightVariable2) {
        this.rightVariable2 = rightVariable2;
    }
}
