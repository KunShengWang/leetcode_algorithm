package com.javaup;

public class Number75 {

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            nums[i] = 2;
            if(x <= 1){
                nums[p1++] = 1;
            }
            if(x == 0){
                nums[p0++] = 0;
            }
        }
    }
}
