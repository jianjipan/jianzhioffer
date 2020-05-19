package com.company;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 思路：与翻转单词顺序 的思路大体一致
 * 我们可以把要左移的字符分成两部分，如例子中：abcXYZdef分成abc 和 XYZdef两部分
 * 然后分别翻转这两部分得到  cba  fedZYX
 * 然后两部分拼接一块再次翻转： 得到 XYZdefabc
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int K){
        if(str==null)
            return null;
        if(str.trim().equals(""))
            return str;
        int start=0;
        int end=str.length()-1;

        char[] chars=str.toCharArray();

        //翻转前一部分
        reverse(chars,start,K-1);
        //翻转后一部分
        reverse(chars,K,end);
        //翻转整个
        reverse(chars,start,end);
        return new String(chars);
    }
    private void reverse(char[] chars,int start,int end){
        char temp=' ';
        while (start<end){
            temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }
}
