package com.javaup.two_pointers;

public class Number11 {

    public static void main(String[] args) {
        int[] heights = new int[]{1,1};
        int ans = maxArea(heights);
        System.out.println(ans);
    }

    public static int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int area = (right - left) * Math.min(height[left],height[right]);
            ans = Math.max(ans,area);
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
