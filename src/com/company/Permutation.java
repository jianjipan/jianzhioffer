package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：递归法，问题转换为先固定第一个字符，求剩余字符的排列；求剩余字符排列时跟原问题一样。
 * (1) 遍历出所有可能出现在第一个位置的字符（即：依次将第一个字符同后面所有字符交换）；
 * (2) 固定第一个字符，求后面字符的排列（即：在第1步的遍历过程中，插入递归进行实现）。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str){
        ArrayList<String> res=new ArrayList<>();
        if(str==null||str.length()==0)
            return res;
        Permutation(str.toCharArray(),0,res);
        Collections.sort(res);
        return res;
    }
    private void Permutation(char[] str,int begin,ArrayList<String> res){
        if(begin==str.length-1){
            String val=String.valueOf(str);
            if(!res.contains(val)){
                res.add(val);
            }
        }else{
            for(int i=begin;i<str.length;i++){
                swap(str,begin,i);
                Permutation(str,begin+1,res);
                swap(str,begin,i);
            }
        }
    }
    public void swap(char[] str,int i,int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }
}
