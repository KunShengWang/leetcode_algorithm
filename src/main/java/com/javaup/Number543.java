package com.javaup;

public class Number543 {

    private int ans = 0;

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        int lLen = dfs(root.left) + 1;
        int rLen = dfs(root.right) + 1;
        ans = Math.max(ans,lLen + rLen);
        return Math.max(lLen,rLen);
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
