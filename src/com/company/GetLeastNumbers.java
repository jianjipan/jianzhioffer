package com.company;

import java.awt.print.Pageable;
import java.util.ArrayList;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 经典常用的算法，快速排序的精髓利用快速排序划分的思想，
 * 每一次划分就会有一个数字位于以数组从小到达排列的的最终位置index；
 * 位于index左边的数字都小于index对应的值,右边都大于index指向的值；
 * 所以，当index > k-1时，表示k个最小数字一定在index的左边，
 * 此时，只需要对index的左边进行划分即可；
 * 当index < k - 1时,说明index及index左边数字还没能满足k个数字，需要继续对k右边进行划分
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers(int[] numbers,int k){
        ArrayList<Integer> res=new ArrayList<>();
        if(numbers==null||numbers.length==0||k<=0||k>numbers.length)
            return res;
        int start=0;
        int end=numbers.length-1;
        int index=Partition(numbers,start,end);
        while (index!=k-1){
            if(index>k-1){
                end=index-1;
                index=Partition(numbers,start,end);
            }
            else{
                start=index+1;
                index=Partition(numbers,start,end);
            }
        }
        for(int i=0;i<k;i++){
            res.add(numbers[i]);
        }
        return res;
    }
    private int Partition(int[] numbers,int start,int end){
        int key=numbers[start];
        while (start<end){
            while (start<end&&numbers[end]>=key)
                end--;
            swap(numbers,start,end);
            while (start<end&&numbers[start]<=key)
                start++;
            swap(numbers,start,end);
        }
        return start;
    }
    private void swap(int[] numbers,int i,int j){
        int temp=numbers[i];
        numbers[i]=numbers[j];
        numbers[j]=temp;
    }

}
