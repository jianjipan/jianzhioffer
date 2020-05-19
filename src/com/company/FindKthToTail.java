package com.company;

import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k){
        if(head==null||k<=0){
            return null;
        }
        ListNode fastNode=head;
        ListNode slowNode=head;
        for(int i=0;i<k-1;i++){
            fastNode=fastNode.next;
            if(fastNode==null){
                return null;
            }
        }
        while (fastNode.next!=null){
            fastNode=fastNode.next;
            slowNode=slowNode.next;
        }
        return slowNode;
    }
}
