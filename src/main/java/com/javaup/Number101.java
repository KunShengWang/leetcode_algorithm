package com.javaup;

public class Number101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left,root.right);
    }

    private boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null || q == null){
            return p == q;
        }
        boolean isSameTreeA = isSameTree(p.left, q.right);
        boolean isSameTreeB = isSameTree(p.right, q.left);
        return p.val == q.val && isSameTreeA && isSameTreeB;
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
