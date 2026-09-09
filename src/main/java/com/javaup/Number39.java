package com.javaup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number39 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0,target,candidates,ans,path);
        return ans;
    }

    private void dfs(int i,int left,int[] candidates,List<List<Integer>> ans,List<Integer> path){
        if(left == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < candidates.length && candidates[j] <= left; j++) {
            path.add(candidates[j]);
            dfs(j,left - candidates[j],candidates,ans,path);
            path.remove(path.size() - 1);
        }
    }
}
