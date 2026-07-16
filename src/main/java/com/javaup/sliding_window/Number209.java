package com.javaup.sliding_window;

public class Number209 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int ans = minSubArrayLen(7, nums);
        System.out.println(ans);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int ans = nums.length + 1;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 缩小窗口大小
            while(sum - nums[left] >= target){
                sum -= nums[left];
                left++;
            }
            if(sum >= target){
                ans = Math.min(ans,right - left + 1);
            }
        }
        return ans <= nums.length ? ans : 0;
    }
}
