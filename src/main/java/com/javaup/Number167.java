package com.javaup;

public class Number167 {

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{-1,0}, -1);
        for (int num : res) {
            System.out.println(num);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            if(numbers[left] + numbers[right] < target){
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }else {
                return new int[]{left + 1,right + 1};
            }
        }
        return new int[]{};
    }
}
