package com.company;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 	 * 思路：
 * 	 * 1、二分查找k在array中出现的最左侧的位置i
 * 	 * 2、二分查找k在array中出现的最右侧的位置j
 * 	 * 3、返回 j-i+1即可
 */
public class GetNumberOfK {
    public int GetNumberOfK(int[] array,int k){
        if(array==null||array.length==0)
            return 0;
        int length=array.length;
        int left=getFirstNumberIndex(array,0,length-1,k);
        int right=getLastNumberIndex(array,0,length-1,k);
        if(left>0&&right>=left){
            return right-left+1;
        }
        return 0;
    }
    // // 递归 二分查找的变形 查找最左侧的k元素
    private int getFirstNumberIndex(int[] array,int start,int end,int k){
        if(start>end){
            return -1;
        }
        int mid=(start+end)>>1;
        int cur=array[mid];
        //cur就是K
        if(cur==k){
            if(mid==0||(mid>0&&array[mid-1]<k)){
                return mid;
            }
        }
        //cur不是K
        int newStart=start;
        int newEnd=end;
        if(cur<k){
            //目标数据在右侧，相等情况下去左侧找
            newStart=mid+1;
        }else {
            //目标数据在左侧
            newEnd=mid-1;
        }
        return getFirstNumberIndex(array,newStart,newEnd,k);
    }
    // 非递归 二分查找的变形 查找最右侧的k元素
    private int getLastNumberIndex(int[] array,int start,int end,int k){
        if(start>end)
            return -1;
        int mid=(start+end)>>1;
        while (start<=end){
            if(array[mid]==k){
                if(mid==array.length-1||((mid<array.length-1)&&array[mid+1]>k))
                    return mid;
            }
            if(array[mid]>k){
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
            mid=(start+end)>>1;
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
