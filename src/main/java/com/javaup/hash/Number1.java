package com.javaup.hash;

import java.util.HashMap;
import java.util.Map;

public class Number1 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        int[] res = twoSum(nums, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.println("下标：" + res[i] + "，值：" + nums[res[i]]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();// key 存数组值，value 存下标
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
