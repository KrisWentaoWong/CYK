package com.company.test;

import com.company.util.ReadcnfFromTxt;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kriswong on 2018/8/20.
 */
public class ReadcnfFromTxtTest {
    @Test
    public void readcnfFromTxt() throws Exception {
        ReadcnfFromTxt readcnfFromTxt = new ReadcnfFromTxt();
        String filename = "/Users/kriswong/Documents/Xcode/CYK/CYK/example_cnf1.txt";
        String filename2 = "/Users/kriswong/Documents/Xcode/CYK/CYK/example_cnf2.txt";
        List<String> rules = readcnfFromTxt.readcnfFromTxt(filename2);
        for(String rule : rules){
            System.out.println(rule);
        }

    }

}