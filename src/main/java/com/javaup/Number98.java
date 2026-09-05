package com.javaup;

public class Number98 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root,long left,long right){
        if(root == null){
            return true;
        }

        long x = root.val;
        return x > left &&
                x < right &&
                isValidBST(root.left,left,x) &&
                isValidBST(root.right,x,right);
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
