package com.company;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
 * B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 */
public class multiply {
    public int[] multiply(int[] A){
        int[] B=new int[A.length];
        if(A==null||A.length==0){
            return B;
        }
        B[0]=1;
        for(int i=1;i<A.length;i++){  //计算上三角
            B[i]=B[i-1]*A[i-1];
        }
        int temp=1;
        for(int j=A.length-2;j>=0;j--){
            temp=temp*A[j+1];   //计算下三角
            B[j]=B[j]*temp;    //上三角和下三角乘积
        }
        return B;
    }
}
