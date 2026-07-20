package com.javaup.prefix_sum;

public class Number53 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,-1,7,8};
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }

    /**
     * 前缀和
     */
//    public static int maxSubArray(int[] nums) {
//        int ans = Integer.MIN_VALUE;
//        int preSum = 0;
//        int minPreSum = 0;
//        for (int num : nums) {
//            preSum += num;
//            ans = Math.max(ans,preSum - minPreSum);
//            minPreSum = Math.min(minPreSum,preSum);
//        }
//        return ans;
//    }

    /**
     * 动态规划
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int ans = f[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + nums[i],nums[i]);
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
}
