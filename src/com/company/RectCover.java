package com.company;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class RectCover {
    public int rectCover(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int number1=1;
        int number2=2;
        int result=0;
        for(int i=3;i<=n;i++){
            result=number1+number2;
            number1=number2;
            number2=result;
        }
        return result;
    }
}
