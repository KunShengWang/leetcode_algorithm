package com.javaup;

import java.util.ArrayList;
import java.util.List;

public class Number78 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,path,ans,nums);
        return ans;
    }

    private void dfs(int i,List<Integer> path,List<List<Integer>> ans,int[] nums){
        ans.add(new ArrayList<>(path));

        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs(j + 1,path,ans,nums);
            path.remove(path.size() - 1);
        }
    }
}
