package com.javaup;

public class Number169 {

    public static void main(String[] args) {
        int ans = majorityElement(new int[]{2});
        System.out.println(ans);
    }

    public static int majorityElement(int[] nums) {
        int hp = 0;
        int ans = 0;
        for (int num : nums) {
            if(hp == 0){
                ans = num;
                hp = 1;
            }else {
                hp += num == ans ? 1 : -1;
            }
        }
        return ans;
    }
}
