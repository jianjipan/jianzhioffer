package com.company;
import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
class ListNode{
    int val;
    ListNode next=null;
    public ListNode(int val){
        this.val=val;
    }
}


public class PrintListFromTailToHead {
    ArrayList<Integer> arrayList=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode node){
        if(node==null)
            return arrayList;
        printListFromTailToHead(node.next);
        arrayList.add(node.val);
        return arrayList;
    }

    public static void main(String[] args) {
        PrintListFromTailToHead printListFromTailToHead=new PrintListFromTailToHead();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        System.out.println(printListFromTailToHead.printListFromTailToHead(node1));
    }
}
