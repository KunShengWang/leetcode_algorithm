package com.javaup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number438 {

    public static void main(String[] args) {
        List<Integer> ans = findAnagrams("a","a");
        for (Integer num : ans) {
            System.out.println(num);
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] countP = new int[26];
        int lenP = p.length();
        for (int i = 0; i < lenP; i++) {
            char c = p.charAt(i);
            countP[c - 97]++;
        }
        int[] countS = new int[26];
        int lenS = s.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < lenS; i++) {
            char c = s.charAt(i);
            countS[c - 97]++;
            int left = i - lenP + 1;
            if(left < 0){
                continue;
            }
            if(Arrays.equals(countP,countS)){
                ans.add(left);
            }
            char out = s.charAt(left);
            countS[out - 97]--;
        }
        return ans;
    }
}
