package com.javaup.array;

public class Number189 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums,2);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int num : nums) {
            builder.append(num).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k == 0){
            return;
        }
        int pos = nums.length - k;
        reverseArray(nums,0,pos - 1);
        reverseArray(nums,pos, nums.length - 1);
        reverseArray(nums,0, nums.length - 1);
    }

    private static void reverseArray(int[] nums, int left, int right){
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
