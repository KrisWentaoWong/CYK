package com.company.util;

import com.company.cnf.CNF;
import com.company.cnf.RuleWithNonTerminal;
import com.company.cnf.RuleWithTerminal;

/**
 * Created by kriswong on 2018/8/19.
 * CYK算法核心方法
 */
public class CYKCore {

    public boolean CYKParse(String sentence, CNF cnf){
        //将读入的句子分割成单词
        String words[] = sentence.split(" ");
        int wordCount = words.length;

        //初始化矩阵
        int matrixLength = wordCount + 1;
        String matrix[][] = new String[matrixLength][matrixLength];

        for(int i=0;i<matrixLength;++i){
            for(int j=0;j<matrixLength;++j){
                matrix[i][j] = "";
            }
        }

        //对CNF规则集进行预处理
        cnf.preProcessRules();

        for(int i=1;i<=wordCount;++i){
            //对于句子中的每一个单词word，能产生word肯定都是cnf中产生终结符的规则，所以只需遍历产生终结符的规则集
            for(int j=0;j<cnf.getRuleWithTerminals().size();++j){
                RuleWithTerminal ruleWithTerminal = cnf.getRuleWithTerminals().get(j);
                //如果words[i]能被这条规则产生，即words[i]在产生式的右边
                if(words[i-1].equals(ruleWithTerminal.getRightVariable().getTerminalVariable())){
                    //将规则左部写入矩阵对应的位置中，多个用;分隔
                    if("".equals(matrix[i-1][i])) {
                        matrix[i-1][i] = ruleWithTerminal.getLeftVariable().getNonterminalVariable();
                    }else{
                        matrix[i-1][i] += (";"+ruleWithTerminal.getLeftVariable().getNonterminalVariable());
                    }
                }
            }

            for(int j=i-2;j>=0;--j){
                for(int k=j+1;k<=i-1;++k){
                    //对于cnf中产生非终结符的规则
                    for(int l=0;l<cnf.getRuleWithNonTerminals().size();++l){
                        RuleWithNonTerminal ruleWithNonTerminal = cnf.getRuleWithNonTerminals().get(l);
                        //A->B C，如果B在matrix[j][k]中且C在matrix[k][j]中
                        if(matrix[j][k].contains(ruleWithNonTerminal.getRightVariable1().getNonterminalVariable()) && matrix[k][i].contains(ruleWithNonTerminal.getRightVariable2().getNonterminalVariable())){
                            if("".equals(matrix[j][i])){
                                matrix[j][i] = ruleWithNonTerminal.getLeftVariable().getNonterminalVariable();
                            }else{
                                matrix[j][i] += (";"+ruleWithNonTerminal.getLeftVariable().getNonterminalVariable());
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<matrixLength;++i){
            for(int j=0;j<matrixLength;++j){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }

        if(matrix[0][wordCount].contains(cnf.getStartSymbol())){
            return true;
        }else{
            return false;
        }
    }

}
