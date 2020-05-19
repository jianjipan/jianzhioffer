package com.company;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 要考虑 溢出问题  和 字符串长度为1 的问题
 */
public class StrToInt {
    public int StrToInt(String str){
        if(str==null)
            return 0;
        int len=str.length();
        int i=0;  //
        int limit=-Integer.MAX_VALUE;  //-0x7FFFFFFF
        int multilimit=0;
        int digit=0;
        int result=0;
        boolean ispositive=true;   //判断是否数值为整数，默认为true
        if(len>1){
            char firstchar=str.charAt(0);
            if(firstchar<'0'||firstchar>'9') {  //如果第一个字符不是0-9，那么判断是不是- 或者+
                if (firstchar == '-') {
                    ispositive = false;
                    limit = Integer.MIN_VALUE;  //0x80000000
                }
                else if(firstchar != '+')  //如果不是-，那么肯定是+，否则是非法字符
                    return 0;
                if(len==1){   //如果字符串长度为1，且第一个字符不是数字，则也返回0
                    return 0;
                }
                i++;
            }
            //除以10的原因是因为每次result都需要和multilimit比较,如果result较小，则下次向前移一位就不会溢出
            multilimit=limit/10;
            while (i<len){
                digit=str.charAt(i++)-'0';
                if(digit<0||digit>9)
                    return 0;
                //首先判断result*10是否溢出?//在判断result*10-digit是否溢出？
                if(result<multilimit)
                    return 0;
                result=result*10;
                if(result<limit+digit)
                    return 0;
                result=result-digit;
            }
        }
        else
        {
            return 0;
        }
        ////如果是正数就返回-result（result一直是负数）
        return ispositive?-result:result;
    }
}
