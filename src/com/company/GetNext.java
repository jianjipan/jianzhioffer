package com.company;
class TreeLinkNode{
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    public TreeLinkNode(int value){
        this.val=value;
    }
}

/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 分情况讨论：
 * 1：该节点有右子树
 * 2：该节点没有右子树
 *    2.1： 该节点是其父节点的左子节点
 *    2.2： 该节点是其父节点的右子节点
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode==null)
            return null;
        TreeLinkNode pNext=null;
        //该节点有右子树
        if(pNode.right!=null){
            TreeLinkNode temp=pNode.right;
            while (temp.left!=null){
                temp=temp.left;
            }
            pNext=temp;
        }
        else if(pNode.next!=null)  //若pNode父节点为null，那么其根节点，又因没有右子树，那么其下一个节点直接返回null即可
        {
            TreeLinkNode parentNode=pNode.next;
            //该节点是其父节点的左子节点
            if(parentNode.left==pNode){
                pNext=parentNode;
            }
            //该节点是其父节点的右子节点
            else if(parentNode.right==pNode){
                TreeLinkNode curNode=pNode;
                //找到第一个左子节点是curNode的节点，或者一直遍历到根节点的下一个节点null。
                while (parentNode!=null&&parentNode.right==curNode){
                    curNode=parentNode;
                    parentNode=parentNode.next;
                }
                pNext=parentNode;
            }
        }
        return pNext;
    }
}
