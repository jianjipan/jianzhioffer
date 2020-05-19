package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 思路：考虑用最大和最小堆来实现。
 * 用一个最大堆 maxHeap  和一个最小堆 minHeap
 * 保证数据平均分配到两个堆中，因此两个堆中的数据的数目之差不能超过1，
 * 我们可以在数据总数目是偶数时将新数据插入最小堆，奇数时插入最大堆。
 * 两个堆中的数据要保证  最大堆的数据 全都小于 最小堆的数据
 * 但是怎么保证插入到最小堆的数据全都大于最大堆的数据？ 做法：可以先把这个数据插入到最大堆
 * 然后从最大堆中得到最大数据，然后再把最大数据插入到最小堆
 *
 * 怎么保证插入到最大堆的数据全都小于最小堆的数据？ 做法：可以先把这个数据插入到最小堆中
 * 然后得到最小堆中的最小数据，然后将其插入到最大堆中。
 */
public class StreamMedian {
    //小顶堆
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    //大顶堆
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    int count=0;
    public void Insert(int data){
        if(count%2==0){  //偶数插入到最小堆
            maxHeap.offer(data);  //先插入到最大堆
            int max=maxHeap.poll();  //得到最大堆中的最大值
            minHeap.offer(max);   //插入到最小堆
        }else
        {
            minHeap.offer(data);
            int min=minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian(){
        if(count%2==0){
            return new Double((maxHeap.peek()+minHeap.peek())/2.0);
        }else
        {
            return new Double(minHeap.peek());
        }
    }
}
