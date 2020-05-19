package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class maxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num,int size){
        ArrayList<Integer> res=new ArrayList<>();
        if(num==null||num.length==0||size<=0||size>num.length){
            return res;
        }
        Deque<Integer> queue=new LinkedList<>();  //双端队列 存储的是下标
        for(int i=0;i<num.length;i++){
            //随着滑动窗口移动，有一些值需要移除(从队头移除)
            while (!queue.isEmpty()&&queue.peek()<i-size+1)
                queue.poll();
            //判断新加入的值是否比队列中的元素大，如果是的话，移除
            while (!queue.isEmpty()&&num[i]>=num[queue.getLast()])
                queue.removeLast();
            queue.add(i);
            //当i+1>size时，就开始记录滑动窗口中的最大值
            if(i+1>=size){
                res.add(num[queue.peek()]);
            }
        }
        return res;
    }
}
