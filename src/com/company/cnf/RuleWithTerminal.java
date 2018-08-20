package com.company.cnf;

/**
 * Created by kriswong on 2018/8/19.
 * 推导出终结符的规则，形如A->a
 */
public class RuleWithTerminal {
    private NonTerminal leftVariable;
    private Terminal rightVariable;

    public String toString(){
        return leftVariable.toString()+"->"+rightVariable.toString();
    }

    public NonTerminal getLeftVariable() {
        return leftVariable;
    }

    public void setLeftVariable(NonTerminal leftVariable) {
        this.leftVariable = leftVariable;
    }

    public Terminal getRightVariable() {
        return rightVariable;
    }

    public void setRightVariable(Terminal rightVariable) {
        this.rightVariable = rightVariable;
    }
}
