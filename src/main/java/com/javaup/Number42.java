package com.javaup;

public class Number42 {

    public static void main(String[] args) {
        int ans = trap(new int[]{4,2,0,3,2,5});
        System.out.println(ans);
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int preMax = 0;
        int sufMax = 0;
        int ans = 0;
        while(left < right){
            preMax = Math.max(preMax,height[left]);
            sufMax = Math.max(sufMax,height[right]);
            if(preMax <= sufMax){
                ans += preMax - height[left];
                left++;
            }else {
                ans += sufMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
