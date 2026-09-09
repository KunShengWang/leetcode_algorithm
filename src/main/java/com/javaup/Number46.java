package com.javaup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number46 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> path = Arrays.asList(new Integer[n]);
        boolean[] onPath = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,nums,path,onPath,ans);
        return ans;
    }

    private void dfs(int i,int[] nums,List<Integer> path,boolean[] onPath,List<List<Integer>> ans){
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if(!onPath[j]){
                path.set(i,nums[j]);
                onPath[j] = true;
                dfs(i + 1,nums,path,onPath,ans);
                onPath[j] = false;
            }
        }
    }
}
