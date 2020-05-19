package com.company;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class MinStack {
    Stack<Integer> mystack=new Stack<>();
    Stack<Integer> minstack=new Stack<>();
    public void push(int data){
        mystack.push(data);
        if(minstack.isEmpty()){
            minstack.push(data);
        }
        else{
            int temp=minstack.peek();
            if(data<=temp){
                minstack.push(data);
            }else
            {
                minstack.push(temp);
            }
        }
    }

    public int pop(){
        minstack.pop();
        return mystack.pop();
    }

    public int top(){
        return mystack.peek();
    }

    public int min(){
        return minstack.peek();
    }
}
