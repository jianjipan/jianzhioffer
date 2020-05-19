package com.company;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class TwoStackToQueue {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    public void push(int value){
        stack1.push(value);
    }
    public int pop(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        int out=stack2.pop();
        return out;
    }

    public static void main(String[] args) {
        TwoStackToQueue twoStackToQueue=new TwoStackToQueue();
        twoStackToQueue.push(1);
        twoStackToQueue.push(2);
        twoStackToQueue.push(3);
        twoStackToQueue.push(4);
        System.out.println(twoStackToQueue.pop());
        System.out.println(twoStackToQueue.pop());
    }
}
