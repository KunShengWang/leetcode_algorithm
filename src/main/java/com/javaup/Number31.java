package com.javaup;

public class Number31 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,2};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if(i >= 0){
            int j = len - 1;
            while (nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i + 1,len - 1);
    }

    private static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private static void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums,left++,right--);
        }
    }
}
