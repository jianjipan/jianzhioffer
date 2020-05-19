package com.company;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am  student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 思路：
 * 第一步：先把整个句子翻转过来：I am student. 变为 .tneduts ma I
 * 第二部：翻转每个单词的顺序  得到 student. ma I
 */
public class ReverseSentence {
    public String ReverseSentence(String str){
        if(str==null)
            return null;
        if(str.trim().equals(""))
            return str;
        char[] chars=str.toCharArray();
        //先把整个句子翻转以下
        reverse(chars,0,str.length()-1);
        int start=0,end=0;
        while (start<str.length()){
            //找到第一个不是空格的下标
            while (chars[start]==' '){
                start++;
                end++;
            }
            //start此时的位置就是单词的第一个字母
            while (end<str.length()&&chars[end]!=' '){
                end++;
            }
            //end此时的位置就是单词的最后一个字母的下一个位置
            reverse(chars,start,end-1);
            start=end+1;
            end=start;
        }
        return new String(chars);
    }
    private void reverse(char[] chars,int start,int end){
        while (start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseSentence rs=new ReverseSentence();
        System.out.println(rs.ReverseSentence("I am student."));
    }
}
