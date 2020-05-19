package com.company;
class RandomListNode{
    int label;
    RandomListNode next=null;
    RandomListNode random=null;
    public RandomListNode(int val){
        this.label=val;
    }
}
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ComplexList {
    public RandomListNode cloneList(RandomListNode head){
        if(head==null)
            return null;
        RandomListNode cur=head;
        // 1.复制next，如原来是A->B->C ，变成A->A'->B->B'->C->C'
        while (cur!=null){
            RandomListNode node=new RandomListNode(cur.label);
            node.next=cur.next;
            cur.next=node;
            cur=node.next;
        }
        //2.复制random，pCur是原来链表的结点 ，pCur.next是复制pCur的结点
        cur=head;
        while (cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }

        //3.分拆两个链表
        cur=head;
        RandomListNode newhead=head.next;
        RandomListNode node=head.next;
        while (cur!=null){
            cur.next=cur.next.next;
            cur=cur.next;
            if(cur!=null){
                node.next=cur.next;
            }
            node=node.next;
        }
        return newhead;
    }
}
