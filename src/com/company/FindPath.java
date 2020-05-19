package com.company;

import sun.reflect.generics.tree.Tree;
/**
 * 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 我们采用递归的思路进行处理，每当深度递归时将当前节点值压入临时链表list中.
 * 若当前节点恰好为叶子节点并且target为0时，那么这就是我们找到的一条路径。我们将此条路径压入listAll中。
 * 无论当前节点是否是叶子节点，再我们进行回退时，均需要将我们此时递归的值弹出，压人是为了做下层递归的路径。
 * 弹出是因为我们已经找到或者没有找到以当前节点为路径节点的路径。因此我们需要回退，让上层节点去其它路径再去寻找。
 */
import java.util.ArrayList;

public class FindPath {
    ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
    ArrayList<Integer> path=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
        if(root==null)
            return  arrayLists;
        path.add(root.val);
        target-=root.val;
        //叶子节点，也是路径节点
        if(target==0&&root.left==null&&root.right==null){
            arrayLists.add(new ArrayList<>(path));   //创建一个新的list并将其压入listAll
        }
        //当前节点不是最终的叶子节点时，继续进行遍历。
        if(target>0){
            FindPath(root.left,target);
            FindPath(root.right,target);
        }
        //临时list中删除当前节点，使上次递归可以去其它节点继续寻找。
        path.remove(path.size()-1);
        return arrayLists;
    }
}
