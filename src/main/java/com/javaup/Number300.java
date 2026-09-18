package com.javaup;

public class Number300 {

    public static void main(String[] args) {

    }

    /**
     * f[i] 表示：以 nums[i] 这个数作为结尾的最长递增子序列长度。
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[i],f[j]);
                }
            }
            ans = Math.max(ans,++f[i]);
        }
        return ans;
    }
}
