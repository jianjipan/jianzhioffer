package com.company;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 考虑用small和big来表示连续序列的最小值和最大值，初始化的时候small为1，big为2，
 * 如果small+。。。+big的和小于S，那么我们考虑增大big的值
 * 如果small+。。。+big的和大于S，那么我们考虑增大small的值
 * 如果等于的话，就向结果集增加这个结果，同步增大big，和 small的值
 *考虑到要至少包括两位数，则small至多增大到(s+1)/2.(不包括(s+1)/2)
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(sum<3)
            return res;
        int small=1;
        int big=2;
        while (small<(sum+1)/2){
            int tempsum=sumOfList(small,big);
            if(tempsum==sum){
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=small;i<=big;i++){
                    list.add(i);
                }
                res.add(list);
                small++;
                big++;
            }
            if(tempsum<sum)
                big++;
            if(tempsum>sum)
                small++;
        }
        return res;
    }
    private int sumOfList(int small,int big){
        int sum=0;
        for(int i=small;i<=big;i++){
            sum+=i;
        }
        return sum;
    }
}
