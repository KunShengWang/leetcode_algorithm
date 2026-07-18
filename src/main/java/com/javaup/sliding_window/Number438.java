package com.javaup.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number438 {

    public static void main(String[] args) {
        List<Integer> ans = findAnagrams("abab","ab");
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Integer an : ans) {
            builder.append(an).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // 统计字符串 p 各个字母出现的顺序
        int[] cntP = new int[26];
        for(char c : p.toCharArray()){
            cntP[c - 'a']++;
        }
        int[] cntS = new int[26];
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            // 增加右端点字符
            cntS[chars[right] - 'a']++;
            int left = right - p.length() + 1;
            if(left < 0){
                continue;
            }
            if(Arrays.equals(cntP,cntS)){
                ans.add(left);
            }
            // 去除左端点字符
            cntS[chars[left] - 'a']--;
        }
        return ans;
    }
}
