package com.company;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum(int[] array){
        if(array.length==0)
            return 0;
        //遍历每个元素，并记录次数，若与前一个元素相同，则次数加1 否则次数减1
        int result=array[0];
        int times=1;
        for(int i=1;i<array.length;i++){
            if(times==0){
                //更新result的值为当前元素，并置次数为1
                result=array[i];
                times=1;
            }
            if(array[i]==result){
                times++;    //相同则加1
            }
            if(array[i]!=result){
                times--;   //不同则减1
            }
        }
        //判断result是否符合条件(有可能会出现不足数组一半的数字)，即出现次数大于数组长度的一半
        times=0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]==result)
                ++times;
        }
        return times>(array.length/2)?result:0;
    }
}
