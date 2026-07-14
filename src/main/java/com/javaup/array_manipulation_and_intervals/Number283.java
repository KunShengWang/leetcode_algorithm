package com.javaup.array_manipulation_and_intervals;

public class Number283 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int[] res = productExceptSelf(nums);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int num : res) {
            builder.append(num).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        System.out.println(builder.toString());
    }

    /**
     * 时间复杂度为：O(n)；空间复杂度为：O(n)
     */
//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] pre = new int[n];
//        pre[0] = 1;
//        for (int i = 1; i < n; i++) {
//            pre[i] = nums[i - 1] * pre[i - 1];
//        }
//
//        int[] suf = new int[n];
//        suf[n - 1] = 1;
//        for (int j = n - 2; j >= 0; j--) {
//           suf[j] = suf[j + 1] * nums[j + 1];
//        }
//
//        int[] ans = new int[n];
//        for (int k = 0; k < n; k++) {
//            ans[k] = pre[k] * suf[k];
//        }
//        return ans;
//    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
           suf[j] = suf[j + 1] * nums[j + 1];
        }

        int pre = 1;
        for (int i = 0; i < n; i++) {
            suf[i] *= pre;
            pre *= nums[i];
        }

        return suf;
    }
}
