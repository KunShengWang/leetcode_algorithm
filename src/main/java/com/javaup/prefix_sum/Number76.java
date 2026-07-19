package com.javaup.prefix_sum;

public class Number76 {

    public static void main(String[] args) {
        String ans = minWindow("a","aa");
        System.out.println(ans);
    }

    public static String minWindow(String s, String t) {
        int[] diff = new int[128];
        int kinds = 0;
        for(char c : t.toCharArray()){
            if(diff[c] == 0){
                kinds++;
            }
            diff[c]--;
        }

        int geCount = 0;
        char[] S = s.toCharArray();
        int m = s.length();
        int left = 0;
        int ansLeft = -1;
        int ansRight = m;
        for (int right = 0; right < m; right++) {
            char c = S[right];
            diff[c]++;
            if(diff[c] == 0){
                geCount++;
            }
            while(geCount == kinds){
                if(right - left < ansRight - ansLeft){
                    ansLeft = left;
                    ansRight = right;
                }
                char x = S[left];
                if(diff[x] == 0){
                    geCount--;
                }
                diff[x]--;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft,ansRight + 1);
    }
}
