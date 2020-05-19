package com.company;

import java.util.LinkedHashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str){
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        int index=-1;
        if(str==null||str.length()==0)
            return index;
        char[] chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                int count=map.get(chars[i]);
                map.put(chars[i],++count);
            }
            else
            {
                map.put(chars[i],1);
            }
        }
        for(int i=0;i<chars.length;i++){
            if(map.get(chars[i])==1){
                index=i;
                return index;
            }
        }
        return index;
    }
}
