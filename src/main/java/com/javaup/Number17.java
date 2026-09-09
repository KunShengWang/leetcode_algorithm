package com.javaup;

import java.util.ArrayList;
import java.util.List;

public class Number17 {

    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        char[] path = new char[n];
        dfs(0,digits,path,ans);
        return ans;
    }

    private void dfs(int i,String digits,char[] path,List<String> ans){
        if(i == digits.length()){
            ans.add(new String(path));
            return;
        }

        String letters = MAPPING[digits.charAt(i) - '0'];
        for (char c : letters.toCharArray()) {
            path[i] = c;
            dfs(i + 1,digits,path,ans);
        }
    }
}
