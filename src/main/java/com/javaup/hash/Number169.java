package com.javaup.hash;

import java.util.HashMap;
import java.util.Map;

public class Number169 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int res = majorityElement(nums);
        System.out.println(res);
    }

    /**
     * 时间复杂度为 O(n)、空间复杂度为 O(n)
     */
//    public static int majorityElement(int[] nums) {
//        // key 放元素；value 放元素出现的次数
//        Map<Integer,Integer> map = new HashMap<>();
//        // 遍历数组
//        for (int num : nums) {
//            map.merge(num,1,(oldValue,newValue) -> oldValue + newValue);
//        }
//        // 遍历 map 集合
//        for (Integer key : map.keySet()) {
//            if(map.get(key) > nums.length / 2){
//                return key;
//            }
//        }
//        return 0;
//    }

    /**
     * 时间复杂度为 O(n)、空间复杂度为 O(1)
     */
    public static int majorityElement(int[] nums) {
        int hp = 0;
        int ans = 0;
        for (int num : nums) {
            if(hp == 0){// num 是初始擂主，生命值为 1
                ans = num;
                hp = 1;
            }else{
                hp += num == ans ? 1 : -1;
            }
        }
        return ans;
    }
}
