package com.company;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class Fibonacci {
    public int fibonacci(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int number1=0;
        int number2=1;
        int result=0;
        for(int i=2;i<=n;i++){
            result=number1+number2;
            number1=number2;
            number2=result;
        }
        return result;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci();
        for (int i=0;i<10;i++){
            System.out.println(fibonacci.fibonacci(i));
        }
    }
}
