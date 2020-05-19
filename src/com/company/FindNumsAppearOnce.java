package com.company;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 思路：
 * 由于如果一个数组中只有一个数字出现一次，其他数字都出现两次，我们就可以将这个数组中每个数异或来求这个唯一的数字
 * 这个题目中有两个数字出现一次，我们要想办法把它们分成两个数组，这两个数字分别出现出现在这两个数组中，这样就可以异或了
 *
 */
public class FindNumsAppearOnce {
    //nums为输入数组，num1，num2为输出
    public void FindNumsAppearOnce(int[] nums,int[] num1,int[] num2){
        if(nums==null||nums.length<2){
            return;
        }
        int AllNumberXOR=nums[0];
        for(int i=1;i<nums.length;i++){
            AllNumberXOR^=nums[i];
        }

        //AllNumberXOR为这两个数的异或值，假设AllNumberXOR中第i位为1，那么这两个数中有一个第i为1，有一个第i为0
        //我们这里来找AllNumberXOR中最右边为1的位。
        int rightbit=FindRightBit(AllNumberXOR);
        //那么这个数组中的数就可以分成两类，与rightbit与操作得到0的数，和与rightbit与操作得到1的数
        for(int i=0;i<nums.length;i++){
            if((nums[i]&rightbit)==0){
                num1[0]^=nums[i];
            }
            else
            {
                num2[0]^=nums[i];
            }
        }

    }
    //找到一个数的二进制最右边为1的位
    //如12，二进制位1100，那么-12为（减1取反）0100 则两者进行&操作，得到0100，
    private int FindRightBit(int number){
        return number&(-number);
    }
}
