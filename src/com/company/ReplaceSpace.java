package com.company;

/***
 * 请实现一个函数，
 * 将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replacespace(StringBuffer sb){
        int emptyNum=0;
        int length=sb.length();
        for(int i=0;i<length;i++){
            if(sb.charAt(i)==' '){
                emptyNum++;
            }
        }
        int newlength=length+2*emptyNum;
        sb.setLength(newlength);
        int i=newlength-1;
        int j=length-1;
        while (i>=0&&j>=0&&i>=j){
            if(sb.charAt(j)==' '){
                sb.setCharAt(i--,'0');
                sb.setCharAt(i--,'2');
                sb.setCharAt(i--,'%');
            }
            else{
                sb.setCharAt(i--,sb.charAt(j));
            }
            j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace rs=new ReplaceSpace();
        StringBuffer sb=new StringBuffer();
        sb.append("I am Daniel");
        System.out.println(rs.replacespace(sb));
    }
}
