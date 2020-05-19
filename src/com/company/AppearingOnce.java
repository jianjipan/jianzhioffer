package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 思路：
 * 设置一个数组，记录每个字符的三种状态：未出现（0），出现一次（1），多次出现（-1）。
 * 设置一个队列，记录每次从字符流中读取时，尚未出现过的字符。
 * 查询当前已读取的字符流中第一个只出现一次的字符，需要判断队首字符状态，执行出列操作直至队首元素只出现过一次。
 * 时间复杂度O(1)，空间复杂度O(1)。
 */
public class AppearingOnce {
    int[] map=new int[256];   //记录字符出现的状态，0表示没有出现，1表示出现一次，-1表示出现多次
    Queue<Character> queue=new LinkedList<>();
    public void Insert(char ch){
        if(map[ch]==0){
            map[ch]=1;
            queue.offer(ch);
        }else
        {
            map[ch]=-1;
        }
    }

    public char FirstAppearingOnce(){
        while (!queue.isEmpty()&&map[queue.peek()]==-1){
            queue.poll();
        }
        if(!queue.isEmpty())
            return queue.peek();
        return '#';
    }
}
