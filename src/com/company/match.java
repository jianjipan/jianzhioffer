package com.company;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class match {
    public boolean match(char[] str,char[] pattern){
        if(str==null||pattern==null)
            return false;
        int strIndex=0;
        int patternIndex=0;
        return matchCore(str,strIndex,pattern,patternIndex);  ////递归地匹配
    }

    private boolean matchCore(char[] str,int strIndex,char[] pattern,int patternIndex){
        ////如果匹配同时到达末尾，则匹配成功
        if(strIndex==str.length&&patternIndex==pattern.length){
            return true;
        }
        //如果模式串先到达末尾，则匹配不成功
        if(strIndex!=str.length&&patternIndex==pattern.length){
            return false;
        }
        ///*如果下一个字符是'*'*/
        if(patternIndex+1<pattern.length&&pattern[patternIndex+1]=='*'){
            //如果当前字符是匹配的
            if(strIndex != str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')){
                return matchCore(str,strIndex,pattern,patternIndex+2)||  ////认为'*'前的字符出现0次
                        matchCore(str,strIndex+1,pattern,patternIndex+2)||  ////认为'*'前的字符出现1次
                        matchCore(str,strIndex+1,pattern,patternIndex);   ////认为'*'前的字符出现多次
            }
            else ////如果当前字符不匹配的 认为'*'前的字符出现0次
            {
                return matchCore(str,strIndex,pattern,patternIndex+2);
            }

        }
        ///*如果下一个字符是'*'*/
        //当前字符是匹配的
        if(strIndex != str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
            return matchCore(str, strIndex+1, pattern, patternIndex+1);
        else{
            return false;
        }
    }
}
