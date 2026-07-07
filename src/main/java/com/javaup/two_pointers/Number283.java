package com.javaup.two_pointers;

public class Number283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int x = 0;// 指向该插入非 0 元素的位置
        int y = 0;// 指向非 0 元素的位置(寻找非 0 元素)
        while(y < nums.length){
            if(nums[y] == 0){
                y++;
            }else{
                nums[x] = nums[y];
                x++;
                y++;
            }
        }
        // 其余位置补 0
        while(x < nums.length){
            nums[x] = 0;
            x++;
        }
    }
}
