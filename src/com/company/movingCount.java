package com.company;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class movingCount {
    public int movingCount(int threshold, int rows, int cols){
        boolean[] flag=new boolean[rows*cols];  //标记已经走过的格子
        return movingCount(threshold,0,0,rows,cols,flag);
    }
    private int movingCount(int threshold,int i,int j,int rows,int cols,boolean[]flag){
        if(i<0||j<0||i>=rows||j>=cols)
            return 0;
        if(flag[i*cols+j]==true||!checkSum(i,j,threshold))
            return 0;
        flag[i*cols+j]=true;
        return 1+movingCount(threshold,i,j+1,rows,cols,flag)+
                movingCount(threshold,i,j-1,rows,cols,flag)+
                movingCount(threshold,i+1,j,rows,cols,flag)+
                movingCount(threshold,i-1,j,rows,cols,flag);
    }
    private boolean checkSum(int i,int j,int threshold){
        int sum=0;
        while (i!=0){
            sum=sum+i%10;
            i=i/10;
        }
        while (j!=0){
            sum=sum+j%10;
            j=j/10;
        }
        return threshold>=sum?true:false;
    }
}
