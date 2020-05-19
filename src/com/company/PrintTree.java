package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer> > res=new ArrayList<>();
        if(pRoot==null)
            return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> arrayList=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode tempNode=queue.poll();
                arrayList.add(tempNode.val);
                if(tempNode.left!=null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right!=null){
                    queue.offer(tempNode.right);
                }
            }
            res.add(arrayList);
        }
        return res;
    }
}
