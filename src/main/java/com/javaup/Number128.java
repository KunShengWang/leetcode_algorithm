package com.javaup;

import java.util.HashSet;
import java.util.Set;

public class Number128 {

    public static void main(String[] args) {
        int ans = longestConsecutive(new int[]{});
        System.out.println(ans);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        int ans = 0;
        for (int x : st) {
            if(st.contains(x - 1)){
                continue;
            }
            int y = x + 1;
            while(st.contains(y)){
                y++;
            }
            ans = Math.max(ans,y - x);
        }
        return ans;
    }
}
