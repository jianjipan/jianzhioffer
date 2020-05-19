package com.company;

/**
 * 用动态规划的思想来分析这个问题。如果用函数f(i)表示以第i个数字结尾的子数组的最大和，那么我们需要求出max[f(i)]，
 * 其中0 <= i <= n。我们可以用如下递归公式求f(i)：
 *
 * f(i) = pData[i]                        i = 0或者f(i-1) <= 0
 *
 * f(i) = f(i-1) + pData[i]           i 不等于 0并且f(i-1) > 0
 *
 * 这个公式的意义：当以第I-1个数字结尾的子数组中所有数字的和小于0时，如果把这个负数与第i个数累加，
 * 则得到的结果比第i个数字本身还要小，所以这种情况下以第I个数字结尾的子数组就是第I个数字本身。
 * 如果以第I-1个数字结尾的子数组中所有数字的和大于0，则与第i个数字累加就得到以第i个数字结尾的子数组中所有数字的和。
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array){
        int currentMaxSum=array[0];  //当前以array[0]结尾的f(i)
        int maxSum=currentMaxSum;  //max[f(i)]
        for(int i=1;i<array.length;i++){
            //求f(i)
            if(currentMaxSum<=0){
                currentMaxSum=array[i];
            }
            else{
                currentMaxSum=currentMaxSum+array[i];
            }
            //求max[f(i)]
            if(maxSum<currentMaxSum)
                maxSum=currentMaxSum;
        }
        return maxSum;
    }
}
