package com.company;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 *
 * //思路：与求二叉树的高度思路一致，但是要左右子树判断高度是否大于1
 */
public class IsBalance {
    private boolean isBalance=true;  //设置一个标志位，用来表示是否为平衡二叉树，默认为true
    public boolean IsBalance(TreeNode root){
        height(root);
        return isBalance;
    }
    private int height(TreeNode root){
        if(root==null||isBalance==false){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(left-right)>1){
            isBalance=false;
        }
        return 1+Math.max(left,right);
    }
}
