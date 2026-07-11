package com.javaup.two_pointers;

public class Number75 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * p0：下一个 0 应该放的位置
     * p1：下一个 1 应该放的位置
     * [0, p0)  全部是 0
     * [p0, p1) 全部是 1
     * [p1, i)  全部是 2
     * 也就是：
     * 0 区域 | 1 区域 | 2 区域 | 未处理区域
     *        p0       p1       i
     */
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = 2;
            if(x <= 1){
                nums[p1++] = 1;
            }
            if(x == 0){
                nums[p0++] = 0;
            }
        }
    }
}
