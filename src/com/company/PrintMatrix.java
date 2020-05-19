package com.company;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatirx(int[][] matrix){
        if(matrix==null)
            return null;
        ArrayList<Integer> arrayList=new ArrayList<>();
        int rows=matrix.length;
        int cols=matrix[0].length;
        int start=0; // 从(0,0)开始循环,圈数：start=0第一圈，start=1第二圈...以此类推
        // 让循环继续的条件是当前行数大于该圈循环开始的行数的两倍以及当前列数大于该圈循环开始的列数的两倍（每圈循环开始的行数、列
        while (rows>2*start&&cols>2*start){
            //每一圈最后一行下标
            int endrow=rows-1-start;
            //每一圈最后一列下标
            int endcol=cols-1-start;
            //开始一圈圈打印，每打印一圈分4步，从左到右，从上到下，从右到左，从下到上
            //从左到右，第一步一定会走
            for(int i=start;i<=endcol;i++)
                arrayList.add(matrix[start][i]);
            //从上到下 最后一行大于开始行
            if(endrow>start){
                for (int i=start+1;i<=endrow;i++)
                    arrayList.add(matrix[i][endcol]);
            }
            if(endcol>start&&endrow>start){
                for(int i=endcol-1;i>=start;i--)
                    arrayList.add(matrix[endrow][i]);
            }
            if(endrow>start+1&&endcol>start){
                for(int i=endrow-1;i>=start;i--){
                    arrayList.add(matrix[i][endcol]);
                }
            }
            // 继续打印下一圈
            start++;
        }
        return arrayList;
    }
}
