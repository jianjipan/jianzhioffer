package com.company;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 表示数字的形式有两种模式：
 * [A].[B]e|E[C]
 * .[B]e|E[C]
 *
 * 其中ABC都是整数，AC可能整数前面有+ -符号
 * 但B只能是纯整数 ，没有正负符号
 * 判断一个字符串是否符合时，我们需要尽可能扫描整数数值部分，即A部分，然后遇到小数点判断B部分，遇到E|e，判断C部分
 */
public class isNumeric {
    private int index=0;
    public boolean isNumeric(char[] str){
        if(str==null||str.length==0)
            return false;
        boolean flag=ScanInteger(str);  //扫描得到A部分
        if(index<str.length&&str[index]=='.'){
            index++;
            //下面一行代码用//的原因
            //1.小数可以没有整数部分，如.123等于0.123
            //2.小数点后面可以没有数字，如233.等于233.0
            //3.当然，小数点前面和后面都可以有数字，如233.666
            ////flag必须放在后面，否则flag放前面，若flag为true的话，就不会执行ScanUnsignedInteger(str)部分了
            // 那么对于233.666E3这个数，666这部分就不会被判断，index值也不会被改变，那么后面的指数部分也不会被判断
            // 导致最后返回false
            flag=ScanUnsignedInteger(str)||flag;
        }
        if(index<str.length&&(str[index]=='e'||str[index]=='E')){
            index++;
            //下面一行代码用&&的原因
            //1.   e3,e4是无效的
            //2.   123e   234E也是无效的
            flag=flag&&ScanInteger(str);
        }
        return flag&&index==str.length;
    }

    private boolean ScanInteger(char[] str){
        if(index<str.length&&(str[index]=='+'||str[index]=='-')){
            index++;
        }
        return ScanUnsignedInteger(str);
    }

    private boolean ScanUnsignedInteger(char[] str){
        int start=index;
        while (index<str.length&&(str[index]>='0'&&str[index]<='9')){
            index++;
        }
        return start<index;
    }

}
