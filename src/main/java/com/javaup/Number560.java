package com.javaup;

import java.util.HashMap;
import java.util.Map;

public class Number560 {

    public static void main(String[] args) {
        int ans = subarraySum(new int[]{1,1,1},2);
        System.out.println(ans);
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        int pre = 0;
        for (int num : nums) {
            pre += num;
            ans += map.getOrDefault(pre - k,0);
            map.merge(pre,1,Integer::sum);
        }
        return ans;
    }
}
