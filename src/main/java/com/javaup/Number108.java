package com.javaup;

public class Number108 {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length);
    }

    private TreeNode dfs(int[] nums,int left,int right){
        if(left == right){
            return null;
        }
        int m = (left + right) / 2;
        return new TreeNode(
                    nums[m],
                    dfs(nums,left,m),
                    dfs(nums,m + 1,right)
                );
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
