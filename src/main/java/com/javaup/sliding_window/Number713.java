package com.javaup.sliding_window;

public class Number713 {

    public static void main(String[] args) {
        int[] nums = new int[]{10,5,2,6};
        int ans = numSubarrayProductLessThanK(nums,100);
        System.out.println(ans);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int prod = 1;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            // 缩小窗口大小
            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
