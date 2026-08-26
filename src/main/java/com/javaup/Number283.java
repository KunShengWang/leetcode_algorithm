package com.javaup;

public class Number283 {

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int x = 0;
        int y = 0;
        while(y < nums.length){
            if(nums[y] == 0){
                y++;
            }else {
                nums[x] = nums[y];
                x++;
                y++;
            }
        }
        while(x < nums.length){
            nums[x++] = 0;
        }
    }
}
