package com.javaup;

import java.util.HashMap;
import java.util.Map;

public class Number1 {

    public static void main(String[] args) {
        int[] ans = twoSum(new int[]{3,3},6);
        for (int an : ans) {
            System.out.println(an);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();// 值:下标

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
