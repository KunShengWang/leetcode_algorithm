package com.javaup;

public class Number104 {

    private int ans= 0;

    public static void main(String[] args) {

    }

//    public int maxDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int depthLeft = maxDepth(root.left);
//        int depthRight = maxDepth(root.right);
//        return Math.max(depthLeft,depthRight) + 1;
//    }

    public int maxDepth(TreeNode root) {
        dfs(root,0);

        return ans;
    }

    private void dfs(TreeNode root,int deep){
        if(root == null){
            return;
        }
        deep++;
        ans = Math.max(ans,deep);
        dfs(root.left,deep);
        dfs(root.right,deep);
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
