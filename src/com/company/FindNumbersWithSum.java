package com.company;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 在数组中选择两个数字，这里我们可以选下标为0的small和下标为len-1的big数字，然后判断它们的和是否为S
 * 如果不是的话，if<S，将small向前移动一位，（即下标加1）
 * 如果if>S  将big向后移动一位（即下标减1）
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array,int sum){
        ArrayList<Integer> res=new ArrayList<>();
        if(array==null||array.length==0)
            return res;
        int small=0;
        int big=array.length-1;
        while (small<big){
            int tempsum=array[small]+array[big];
            if(tempsum==sum){
                res.add(array[small]);
                res.add(array[big]);
                return res;
            }
            if(tempsum<sum)
                small++;
            if(tempsum>sum)
                big--;
        }
        return res;
    }
}
