package com.javaup.hash;

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
}

class RandomizedSet {

    int[] nums;
    Random random;
    Map<Integer,Integer> map;// key 存元素；value 存元素在数组的下标
    int index;// 用于存储数组最后一个元素的位置

    public RandomizedSet() {
        nums = new int[200010];
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
        Integer loc = map.remove(val);// 拿到被删除元素的下标
        if(loc != index){
            map.put(nums[index],loc);
        }
        nums[loc] = nums[index--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(index + 1)];
    }
}