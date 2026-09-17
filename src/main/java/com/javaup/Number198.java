package com.javaup;

public class Number198 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 2];
        f[0] = f[1] = 0;
        for (int i = 0; i < n; i++) {
            f[i + 2] = Math.max(f[i + 1],nums[i] + f[i]);
        }
        return f[n + 1];
    }
}
