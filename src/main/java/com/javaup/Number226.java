package com.javaup;

public class Number226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode treeNodeLeft = invertTree(root.left);
        TreeNode treeNodeRight = invertTree(root.right);
        root.right = treeNodeLeft;
        root.left = treeNodeRight;
        return root;
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
