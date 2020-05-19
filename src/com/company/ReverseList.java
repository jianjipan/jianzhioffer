package com.company;

import java.util.List;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head){
        ListNode cur=head; //指向当前结点
        ListNode pre=null;  //指向当前节点的前一个结点
        ListNode temp=null; //保存当前结点的下一个结点
        while (cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

}
