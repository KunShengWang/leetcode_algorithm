package com.javaup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number15 {

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> list : res) {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (Integer num : list) {
                builder.append(num).append(",");
            }
            if (!builder.isEmpty()) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append("]");
            System.out.println(builder.toString() + "\n");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            // 优化 1:去重
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 优化 2:提前结束
            if(nums[i] + nums[i + 1] + nums[i + 2] > 0){
                break;
            }
            // 优化 3:提前结束
            if(nums[i] + nums[len - 1] + nums[len - 2] < 0){
                continue;
            }

            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                } else if (sum > 0) {
                    k--;
                }else {
                    res.add(List.of(nums[i] , nums[j] , nums[k]));
                    // 这块也得去除重复三元组
                    for(j++;j < k && nums[j] == nums[j - 1];j++);
                    for(k--;k > j && nums[k] == nums[k + 1];k--);
                }
            }
        }
        return res;
    }
}
