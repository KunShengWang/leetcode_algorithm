package com.javaup;

public class Number136 {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}
