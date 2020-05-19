package com.company;

import sun.reflect.generics.tree.Tree;

/**
 * 给定一棵二叉搜索树，
 * 请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * 二叉搜索树的中序遍历序列就是一个升序序列，所以可以用中序遍历序列来求得
 */
public class KthNode {
    int count=0;
    TreeNode res=null;
    public TreeNode KthNode(TreeNode pRoot,int k){
        if(pRoot==null){
            return null;
        }
        KthNode(pRoot.left,k);
        count++;
        if(count==k){
            res=pRoot;
        }
        KthNode(pRoot.right,k);
        return res;
    }
}
