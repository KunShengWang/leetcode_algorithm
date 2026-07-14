package com.javaup.sliding_window;

public class Number3 {

    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int ans = 0;
        int[] cnt = new int[128];// 用于记录当前窗口下的字符数量
        for (int right = 0; right < chars.length; right++) {
            char c = chars[right];
            cnt[c]++;
            while(cnt[c] > 1){
                // 把窗口最左端的值去除，去除的同时要更新窗口中字符的数量
                cnt[chars[left]]--;
                left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
}
