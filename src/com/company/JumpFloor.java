package com.company;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    public int jumpFloor(int n){
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
