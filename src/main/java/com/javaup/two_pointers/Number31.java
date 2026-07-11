package com.javaup.two_pointers;

public class Number31 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 第一阶段
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        // 第二阶段
        if(i >= 0){
            int j = n - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        // 第三阶段
        reverse(nums,i+1,n-1);
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
