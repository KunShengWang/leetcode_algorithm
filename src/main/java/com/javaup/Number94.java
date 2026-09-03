package com.javaup;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Number94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else{
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
        }
        return res;
    }


    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
