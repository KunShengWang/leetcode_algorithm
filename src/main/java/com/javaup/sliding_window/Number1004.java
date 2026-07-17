package com.javaup.sliding_window;

public class Number1004 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int ans = longestOnes(nums,3);
        System.out.println(ans);
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int count0 = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0){
                count0++;
            }
            while(count0 > k){
                if(nums[left] == 0){
                    count0--;
                }
                left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
}
