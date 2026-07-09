package com.javaup.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,0,0,3,3,3};
        List<List<Integer>> ans = threeSum(nums);
        for (List<Integer> list : ans) {
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
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            // 去除重复三元组
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 优化，减少计算
            if(nums[i] + nums[i + 1] + nums[i + 2] > 0){
                break;
            }
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
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    // 去除重复三元组
                    for(j++;j < k && nums[j] == nums[j - 1];j++);
                    for(k--;k > j && nums[k] == nums[k + 1];k--);
                }
            }
        }
        return ans;
    }
}
