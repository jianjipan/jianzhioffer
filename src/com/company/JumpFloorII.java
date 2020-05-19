package com.company;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    public int jumpFloor2(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        int number1=1;
        int result=0;
        for(int i=2;i<=n;i++){
            result=2*number1;
            number1=result;
        }
        return result;
    }
}
