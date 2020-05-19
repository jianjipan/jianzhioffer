package com.company;

import sun.reflect.generics.tree.Tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 第一步，在树Ａ中找到和树Ｂ的根节点的值一样的节点Ｒ
 * 第二步，判断Ａ中以Ｒ为根节点的子树是不是包含和树Ｂ一样的结构
 */
public class HasSubTree {
    public boolean HasSubTree(TreeNode root1, TreeNode root2){
        //当root1和root2为null的时候,直接返回false
        if(root1==null||root2==null){
            return false;
        }
        boolean result=false;
        ////如果找到了对应root2的根节点的点
        if(root1.val== root2.val)
            ////以这个根节点为为起点判断是否包含root2
            result=Judge(root1,root2);
        if(!result)
            ////如果找不到，那么就再去root1的左儿子当作起点，去判断时候包含root2
            result=HasSubTree(root1.left,root2);
        if(!result)
            ////如果还找不到，那么就再去root1的右儿子当作起点，去判断时候包含root2
            result=HasSubTree(root1.right,root2);
        return result;
    }

    public boolean Judge(TreeNode node1,TreeNode node2){
        ////如果node2已经遍历完了都能对应的上，返回true
        if(node2==null)
            return true;
        ////如果node2还没有遍历完，node1却遍历完了。返回false
        if(node1==null)
            return false;
        //如果其中有一个点没有对应上，返回false
        if(node1.val!=node2.val)
            return false;
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return Judge(node1.left,node2.left)&&Judge(node1.right,node2.right);
    }

}
