package com.company;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class Power {
    public double Power(double base,int exponent) {
        if (base == 0.0 && exponent < 0) {
            try {
                throw new Exception("Invaild Input");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(base==0.0&&exponent>0){
            return 0.0;
        }
        double result=1.0;
        if(exponent>=0){
            for(int i=0;i<exponent;i++){
                result=result*base;
            }
            return result;
        }
        if(exponent<0){
            for(int i=0;i<-exponent;i++){
                result=result*base;
            }
            return 1.0/result;
        }
        return result;
    }
}
