package com.company;

/**
 * 在数组中的两个数字，
 * 如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    int count=0;
    public int InversePairs(int[] array){
        if(array==null||array.length==0)
            return count;
        int[] tempArr=new int[array.length];
        mergeSort(array,0,array.length-1,tempArr);
        return count;
    }

    private void mergeSort(int[] array,int start,int end,int[] temp){
        if(start>=end){
            return;
        }
        int mid=(start+end)>>1;
        mergeSort(array,start,mid,temp);
        mergeSort(array,mid+1,end,temp);
        merge(array,start,mid,end,temp);
    }
    private void merge(int[] array,int start,int mid,int end,int[] temp){
        int index=start;  //temp的下标
        int start2=mid+1;  //第二个归并端
        int i=start;
        while (start<=mid&&start2<=end)
        {
            if(array[start]>array[start2]){
                temp[index++]=array[start++];
                count=(count+end-start2+1)%1000000007;
            }
            else{
                temp[index++]=array[start2++];
            }
        }
        if(start2<=end){
            System.arraycopy(array,start2,temp,index,end-start2+1);
        }
        if(start<=mid){
            System.arraycopy(array,start,temp,index,mid-start+1);
        }
        System.arraycopy(temp,i,array,i,end-i+1);
    }
}
