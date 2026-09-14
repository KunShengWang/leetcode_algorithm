package com.javaup;

public class Number153 {

    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
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
        return nums[left];
    }
}
