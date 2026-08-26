package com.javaup;

public class Number11 {

    public static void main(String[] args) {
        int ans = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(ans);
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = 0;
        while(left < right){
            max = Math.max(max,(right - left) * Math.min(height[left],height[right]));
            if(height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
