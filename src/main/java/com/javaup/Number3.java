package com.javaup;

public class Number3 {

    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int[] ac = new int[128];
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            ac[c]++;
            while(ac[c] > 1){
                ac[chars[left]]--;
                left++;
            }
            ans = Math.max(ans,i - left + 1);
        }
        return ans;
    }
}
