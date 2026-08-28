package com.javaup;

public class Number209 {

    public static void main(String[] args) {
        int ans = minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1});
        System.out.println(ans);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return ans <= n ? ans : 0;
    }
}
