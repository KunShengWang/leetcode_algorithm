package com.javaup.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Number904 {

    public static void main(String[] args) {
        int[] fruits = new int[]{1,2,1};
        int ans = totalFruit(fruits);
        System.out.println(ans);
    }

    public static int totalFruit(int[] fruits) {
        int ans = 0;
        int left = 0;
        int n = fruits.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            map.merge(fruits[right],1, Integer::sum);
            while(map.size() > 2){
                map.merge(fruits[left],-1, Integer::sum);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
}
