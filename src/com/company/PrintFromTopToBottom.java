package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(root==null){
            return arrayList;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            arrayList.add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return arrayList;
    }
}
