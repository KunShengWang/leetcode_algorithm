package com.javaup;

import java.util.HashMap;
import java.util.Map;

public class Number437 {

    private int ans;

    public static void main(String[] args) {
        
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> cnt = new HashMap<>();
        cnt.put(0L,1);
        dfs(root,0,targetSum,cnt);
        return ans;
    }

    private void dfs(TreeNode root,long s,int targetSum,Map<Long,Integer> cnt){
        if(root == null){
            return;
        }
        s += root.val;
        ans += cnt.getOrDefault(s - targetSum,0);
        cnt.merge(s,1,Integer::sum);
        dfs(root.left,s,targetSum,cnt);
        dfs(root.right,s,targetSum,cnt);
        cnt.merge(s,-1,Integer::sum);
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
