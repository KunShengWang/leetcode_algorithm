package com.javaup;

public class Number53 {

    public static void main(String[] args) {
        int ans = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(ans);
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        int ans = pre[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1] + nums[i],nums[i]);
            ans = Math.max(ans,pre[i]);
        }
        return ans;
    }
}
