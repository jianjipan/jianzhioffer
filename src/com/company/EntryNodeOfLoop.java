package com.company;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 若无环的话，指针一直向前移动，会移动到null结点
 * 若有环的话，指针会一直循环出不来，我们设起点到入环结点的距离为S，入环节点到相遇点的距离L，环的长度为R
 * 我们设置两个指针，一个快指针，一个慢指针
 * 快指针一次走两步，慢指针一次走一步
 * 则两个指针一定会在环上的某一点相遇，此时
 * 慢指针走了（S+L）的距离
 * 快指针走了（S+L+nR）的距离
 * 那么有公式  2（S+L）=（S+L+nR）=>  S=nR-L
 * 上述公式说明，当有两个点一个从相遇点开始走，一个从起点开始走，那么它们一定相遇在入口节点处。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode head){
        if(head==null){
            return null;
        }
        ListNode fastNode=head;
        ListNode slowNode=head;
        while (fastNode!=null&&fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(fastNode==slowNode){
                fastNode=head;
                while (slowNode!=fastNode){
                    slowNode=slowNode.next;
                    fastNode=fastNode.next;
                }
                return slowNode;
            }
        }
        return null;
    }
}
