package com.javaup;

public class Number33 {

    public static void main(String[] args) {
        int ans = search(new int[]{1},0);
        System.out.println(ans);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int pos = finMin(nums);
        if(target > nums[n - 1]){
            return searchNumber(nums,0,pos - 1,target);
        }
        return searchNumber(nums,pos,n - 1,target);
    }

    private static int finMin(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[n - 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private static int searchNumber(int[] nums,int left,int right,int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
