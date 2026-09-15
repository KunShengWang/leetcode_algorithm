package com.javaup;

public class Number45 {

    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int ans = 0;
        int curEnd = 0;
        int nextEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextEnd = Math.max(nextEnd,i + nums[i]);
            if(i == curEnd){
                curEnd = nextEnd;
                ans++;
            }
        }
        return ans;
    }
}
