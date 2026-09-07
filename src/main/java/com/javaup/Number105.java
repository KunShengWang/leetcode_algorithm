package com.javaup;

public class Number105 {

    public static void main(String[] args) {
        
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return null;
    }

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
