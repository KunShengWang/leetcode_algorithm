package com.javaup.two_pointers;

public class Number42 {

    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        int ans = trap(height);
        System.out.println(ans);
    }

    /**
     * 核心公式：water[i]=min(leftMax[i],rightMax[i])−height[i]
     * 其中：
        height[i]：位置 i 自己的柱子高度；
        leftMax[i]：位置 i 左边最高柱子的高度，通常包括 i 自己；
        rightMax[i]：位置 i 右边最高柱子的高度，通常包括 i 自己；
        water[i]：位置 i 上方能够存储的雨水高度。
     */
    public static int trap(int[] height) {
        int ans = 0;
        int preMax = 0;
        int sufMax = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            preMax = Math.max(preMax,height[left]);
            sufMax = Math.max(sufMax,height[right]);
            if(preMax < sufMax){
                ans += preMax - height[left];
                left++;
            }else {
                ans += sufMax - height[right];
                right--;
            }
        }
        return  ans;
    }
}
