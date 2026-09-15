package com.javaup;

import java.util.*;

public class Number347 {

    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        // 第一步：统计每个元素的出现次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num,1,Integer::sum);
        }
        int maxCount = Collections.max(map.values());

        // 第二步：把出现次数相同的元素，放到同一个桶中
        List<Integer>[] buckets = new ArrayList[maxCount + 1];
        Arrays.setAll(buckets,bucket -> new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        // 第三步：倒序遍历 buckets，把出现次数前 k 大的元素加入答案
        int[] ans = new int[k];
        int j = 0;
        for (int i = maxCount; j < k ; i--) {
            for (Integer x : buckets[i]) {
                ans[j++] = x;
            }
        }
        return ans;
    }
}
