package com.javaup.sliding_window;

public class Number1493 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int ans = longestSubarray(nums);
        System.out.println(ans);
    }

    public static int longestSubarray(int[] nums) {
        int count0 = 0;
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0){
                count0++;
            }
            while(count0 > 1){
                if(nums[left] == 0){
                    count0--;
                }
                left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans - 1;
    }
}
