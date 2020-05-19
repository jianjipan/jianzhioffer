package com.company;

import java.io.Serializable;

public class SerializeAndDeSerialize {
    public String Serialize(TreeNode root){
        StringBuilder sb=new StringBuilder();
        return Serialize(root,sb);
    }
    private String Serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    int index=-1;
    public TreeNode DeSerialize(String str){
        if(str==null||str.length()==0)
            return null;
        String[] strs=str.split(",");
        return DeSerialize(strs);
    }
    public TreeNode DeSerialize(String[] strings){
        index++;
        if(index<strings.length&&!strings[index].equals("#")){
            TreeNode cur=new TreeNode(Integer.valueOf(strings[index]));
            cur.left=DeSerialize(strings);
            cur.right=DeSerialize(strings);
            return cur;
        }
        return null;
    }
}
