package com.javaup;

public class Number41 {

    public static void main(String[] args) {
        int ans = firstMissingPositive(new int[]{1,1,2});
        System.out.println(ans);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums,i,nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }

    private static void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
