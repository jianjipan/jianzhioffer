package com.company;

import javax.swing.*;

/**
 *在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(0);  //解决删除头节点的可能
        newHead.next=pHead;
        ListNode preNode=newHead;
        ListNode curNode=pHead;
        while (curNode!=null){
            if(curNode.next!=null&&curNode.val==curNode.next.val){
                while (curNode.next!=null&&curNode.val==curNode.next.val){
                    curNode=curNode.next;
                }
                preNode.next=curNode.next;
            }
            else
            {
                preNode=curNode;
            }
            curNode=curNode.next;
        }
        return newHead.next;
    }
}
