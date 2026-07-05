package com.javaup.hash;

import java.util.HashSet;
import java.util.Set;

public class Number128 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,2};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        int max = 0;
        for (int num : st) {
            if(st.contains(num - 1)){
                continue;
            }
            int next = num + 1;
            while(st.contains(next)){
                next++;
            }
            max = Math.max(max,next - num);
        }
        return max;
    }
}
