package com.company;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *
 *         //1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
 *         //2、定位到左链表的最后一个节点(左子树最右边的节点)
 *         //3、如果左子树链表不为空，则将当前root追加到左子树链表后
 *         //4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
 *         //5、如果右子树链表不为空，将右子树链表追加到当前root后
 *         //6，根据左子树链表是否为空返回的整体双向链表的头节点
 *         //Convert函数把一个二叉搜索树变成一个有序的双向链表，返回双向链表的头结点，参数root为二叉搜索树的根节点
 *
 */
public class Convert {
    public TreeNode Convert(TreeNode root){
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        //将左子树构成双链表，并返回左子树最左边的节点
        TreeNode left=Convert(root.left);
        //定位到左链表的最后一个节点（左子树最右边的节点）
        TreeNode p=left;
        while (p!=null&&p.right!=null){
            p=p.right;
        }
        //如果左子树链表不为空，则将当前root追加到左子树链表后
        if(left!=null){
            p.right=root;
            root.left=p;
        }
        //将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
        TreeNode right=Convert(root.right);
        //如果右子树链表不为空，将右子树链表追加到当前root后
        if(right!=null){
            right.left=root;
            root.right=right;
        }
        //根据左子树链表是否为空返回的整体双向链表的头节点
        return left==null?root:left;
    }
}
