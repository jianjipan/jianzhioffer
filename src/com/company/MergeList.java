package com.company;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public ListNode MergeList(ListNode Ahead,ListNode Bhead){
        if(Ahead==null&&Bhead==null)
            return null;
        if(Bhead==null)
            return Ahead;
        if(Ahead==null)
            return Bhead;
        ListNode mergeList=null;
        if(Ahead.val<=Bhead.val){
            mergeList=Ahead;
            mergeList.next=MergeList(Ahead.next,Bhead);
        }
        if(Ahead.val>Bhead.val){
            mergeList=Bhead;
            mergeList.next=MergeList(Ahead,Bhead.next);
        }
        return mergeList;
    }
}
