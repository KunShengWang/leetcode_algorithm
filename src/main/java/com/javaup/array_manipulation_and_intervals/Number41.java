package com.javaup.array_manipulation_and_intervals;

public class Number41 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 换位置
        for (int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums,i,nums[i] - 1);
            }
        }
        // 找座错位置的学生
        for (int j = 0; j < n; j++) {
            if(nums[j] - 1 != j){
                return j + 1;
            }
        }
        return n + 1;
    }

    private static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
