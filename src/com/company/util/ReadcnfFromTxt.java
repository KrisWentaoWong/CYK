package com.company.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kriswong on 2018/8/20.
 * 从txt文件中读取规则集
 */
public class ReadcnfFromTxt {
    public List<String> readcnfFromTxt(String filename){
        List<String> rules = new ArrayList<>();
        File file = new File(filename);
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String rule = null;
            while((rule = reader.readLine()) != null){
                rules.add(rule);
            }
        }catch (Exception e){
            System.out.println("读取文件失败！");
            e.printStackTrace();
        }
        return rules;
    }
}
