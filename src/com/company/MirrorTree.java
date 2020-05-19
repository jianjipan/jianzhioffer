package com.company;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorTree {
    public void Mirror(TreeNode root){
        if(root==null)
            return;
        change(root);
        Mirror(root.left);
        Mirror(root.right);
    }
    public void change(TreeNode node){
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
    }

}
