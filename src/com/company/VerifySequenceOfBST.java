package com.company;

/**
 * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySequenceOfBST {
    public boolean VerifySequenceOfBST(int[] sequence){
        if(sequence.length==0){
            return false;
        }
        return VerifySequenceOfBST(sequence,0,sequence.length-1);
    }

    public boolean VerifySequenceOfBST(int[] sequence,int start,int end){

        if(start>=end)
            return true;

        //找到左子树和右子树的分界点。下面这段代码是错误的，没有考虑到整个序列全小于根节点的情况，如果整个序列全小于
        //sequence[end]的话，我们得到的分界点bound就是错误的
//        int bound=start;
//        for(int i=start;i<end;i++){
//            if(sequence[i]>root){
//                bound=i;
//                break;
//            }
//        }

        //找到左子树和右子树的分界点
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        //验证右子树是不是都大于根节点
        for(int j=i;j<end;j++){
            if(sequence[j]<sequence[end]){
                return false;
            }
        }
        //递归检查左子树和右子树
        return VerifySequenceOfBST(sequence,start,i-1)&&VerifySequenceOfBST(sequence,i,end-1);
    }

}
