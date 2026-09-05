package com.javaup;

public class Number114 {

    private TreeNode head;

    public static void main(String[] args) {
        
    }

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = head;
        head = root;
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
