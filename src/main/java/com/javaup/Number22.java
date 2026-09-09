package com.javaup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number22 {

    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0,0,n,path,ans);
        return ans;
    }

    private void dfs(int i,int balance,int n,List<Integer> path,List<String> ans){
        if(path.size() == n){
            char[] chars = new char[n * 2];
            Arrays.fill(chars,')');
            for (Integer pos : path) {
                chars[pos] = '(';
            }
            ans.add(new String(chars));
            return;
        }

        for (int right = 0; right <= balance; right++) {
            path.add(right + i);
            dfs(right + i + 1,balance - right + 1,n,path,ans);
            path.remove(path.size() - 1);
        }
    }
}
