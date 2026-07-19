package com.javaup.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class Number560 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int ans = subarraySum(nums,3);
        System.out.println(ans);
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            // 前缀和出现的次数
            Integer count = prefix.get(sum - k);
            if (count != null) {
                ans += count;
            }
            prefix.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}
