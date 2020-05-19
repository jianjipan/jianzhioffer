package com.company;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

/**
 * 1、要想保证原有的次序，则只能顺序移动或者相邻交换；
 * 2、i 从左到右开始遍历，找到第一个偶数；
 * 3、j 从 i+1 开始向后找，直到找到第一个奇数；
 * 4、将 [ i , ... . j - 1 ] 的元素整体后移一位，最后将找到的奇数放入 i 位置，然后 i++；
 * 5、终止条件，j 向后遍历查找失败，即后面没有奇数了。
 */
public class reOrderArray {
    public void reOrderArray(int[] array) {
        if(array.length==0&&array==null){
            return;
        }
        int i=0;
        int j=0;
        int length=array.length;
        while (i<length){
            while(i<length&&(array[i]&1)!=0){
                i++;
            }
            j=i+1;
            // i指向偶数时，j从i+1开始向后遍历找奇数
            while (j<length&&(array[j]&1)==0){
                j++;
            }
            if(j<length){
                int temp=array[j];
                for(int k=j-1;k>=i;k--){
                    array[k+1]=array[k];
                }
                array[i]=temp;
                i++;
            }
            else{
                break;
            }
        }
    }
}
