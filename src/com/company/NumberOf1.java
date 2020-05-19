package com.company;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public int NumberOf1(int number){
        int count=0;
        while (number!=0){
            number=number&(number-1);
            count++;
        }
        return count;
    }
}
