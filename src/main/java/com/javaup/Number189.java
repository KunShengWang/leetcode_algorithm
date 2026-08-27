package com.javaup;

public class Number189 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums,2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums,0,len - k -1);
        reverse(nums,len - k,len - 1);
        reverse(nums,0,len - 1);
    }

    private static void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private static void reverse(int[] nums,int left,int right){
        while(left < right){
            swap(nums,left++,right--);
        }
    }
}
