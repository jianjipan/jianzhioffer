package com.company;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 思路：
 * 动态规划，先自上而下分析，在长度为n的绳子所求为f(n)，剪下一刀后剩下的两段长度是i和n-i，
 * 在这个上面还可能继续减(子问题)，所以：
 * f(n)=max(f(i)×f(n−i))
 * 然后自下而上的解决问题，可以从f(1)开始向上计算并打表保存，最终获得f(n)的值。
 */
public class cutRope {
    public int cutRope(int n){
        if(n<=1)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;

        //运行至此,说明绳子的长度是>3的,这之后f(0)/f(1)/f(2)/f(3)这种子问题最大就是其自身长度
        //而不再需要考虑剪一刀的问题,因为它们剪一刀没有不剪来的收益高
        int[] products = new int[n+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;//到3为止都是不剪最好

        for(int i=4;i<=n;i++){
            int max=0;
            for(int j=1;j<=i/2;j++){
                //计算f(j)乘以f(i-j)
                int multiply=products[i-j]*products[j];
                //如果比当前找到的还大
                if(multiply>max)
                    max=multiply;
            }
            //将各个长度的最大值记录在products[i]中
            products[i]=max;
        }
        int max=products[n];
        return max;
    }
}
