package com.company;

import com.company.cnf.CNF;
import com.company.util.CYKCore;
import com.company.util.ReadcnfFromTxt;

import java.util.List;

public class CYKMain {

    public static void main(String[] args) {
	// write your code here
        ReadcnfFromTxt readcnfFromTxt = new ReadcnfFromTxt();
        CYKCore cykCore = new CYKCore();
        CNF cnf1 = new CNF();
        CNF cnf2 = new CNF();
        String filename1 = "/Users/kriswong/projects/CYK/src/com/company/testFile/example_cnf1.txt";
        String filename2 = "/Users/kriswong/projects/CYK/src/com/company/testFile/example_cnf2.txt";
        List<String> rules1 = readcnfFromTxt.readcnfFromTxt(filename1);
        List<String> rules2 = readcnfFromTxt.readcnfFromTxt(filename2);

        cnf1.setOriginalRules(rules1);
        cnf2.setOriginalRules(rules2);

//        boolean result1 = cykCore.CYKParse("a a a a a",cnf1);
        boolean result2 = cykCore.CYKParse("she eats a fish with a fork",cnf2);
//        System.out.println(result1);
        System.out.println(result2);
    }
}
