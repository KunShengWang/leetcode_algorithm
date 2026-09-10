package com.javaup;

import java.util.ArrayList;
import java.util.List;

public class Number131 {

    public static void main(String[] args) {

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0,s,path,ans);

        return ans;
    }

    private void dfs(int i,String s,List<String> path,List<List<String>> ans){
        if(i == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if(isPalindrome(s,i,j)){
                path.add(s.substring(i,j + 1));
                dfs(j + 1,s,path,ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s,int i,int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
