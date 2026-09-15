package com.javaup;

import java.util.ArrayList;
import java.util.List;

public class Number763 {

    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int[] last = new int[26];
        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end,last[chars[i] - 'a']);
            if(i == end){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
