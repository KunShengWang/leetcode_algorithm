package com.javaup;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Number380 {

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        int param_3 = obj.getRandom();
    }

    static class RandomizedSet {

        private int[] nums;
        private Random random;
        private Map<Integer,Integer> map;
        private int index;

        public RandomizedSet() {
            nums = new int[200000];
            random = new Random();
            map = new HashMap<>();
            index = -1;
        }

        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            nums[++index] = val;
            map.put(val,index);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            Integer pos = map.remove(val);
            if(pos != index){
                map.put(nums[index],pos);
            }
            nums[pos] = nums[index--];
            return true;
        }

        public int getRandom() {
            return nums[random.nextInt(0,index + 1)];
        }
    }
}

