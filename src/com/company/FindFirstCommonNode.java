package com.company;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，
 * 所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=p2){
            p1=(p1==null)?pHead2:p1.next;
            p2=(p2==null)?pHead1:p2.next;
        }
        return p1;
    }
}
