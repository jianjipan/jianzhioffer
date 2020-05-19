package com.company;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindArray {
    public boolean Find(int[][] array,int target){
        int row=array.length;
        int col=array[0].length;
        int i=0;
        int j=col-1;
        while (i<row&&j>=0){
            if(array[i][j]<target){
                i++;
            }
            else if(array[i][j]>target){
                j--;
            }
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int array[][]={
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(new FindArray().Find(array,10));
    }
}
