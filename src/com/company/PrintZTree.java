package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZTree {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(pRoot==null)
            return res;
        boolean flag=true;   //为true时正序，为false为逆序
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> arrayList=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode tempNode=queue.poll();
                if(flag==true){
                    arrayList.add(tempNode.val);
                }else
                {
                    arrayList.add(0,tempNode.val);
                }
                if(tempNode.left!=null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right!=null){
                    queue.offer(tempNode.right);
                }
            }
            res.add(arrayList);
            flag=!flag;
        }
        return res;
    }
}
