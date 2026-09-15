package com.javaup;

import java.util.Random;

public class Number215 {

    private final Random rd = new Random();

    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int targetIndex = n - k;
        while (true){
            int i = partition(nums,left,right);
            if(i == targetIndex){
                return nums[i];
            }
            if(i > targetIndex){
                right = i - 1;
            }else {
                left = i + 1;
            }
        }
    }

    private int partition(int[] nums,int left,int right){
        int i = left + rd.nextInt(right - left + 1);
        int pivot = nums[i];
        swap(nums,left,i);

        i = left + 1;
        int j = right;
        while (true){
            while (i <= j && nums[i] < pivot){
                i++;
            }
            while (i <= j && nums[j] > pivot){
                j--;
            }
            if(i >= j){
                break;
            }
            swap(nums,i,j);
            i++;
            j--;
        }
        swap(nums,left,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
