package com.javaup;

public class Number230 {

    private int k;
    private int ans;

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null || k <= 0){
            return;
        }
        dfs(root.left);
        if(--k == 0){
            ans = root.val;
        }
        dfs(root.right);
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
