package com.javaup.prefix_sum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Number239 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] ans = maxSlidingWindow(nums, 1);
        for (int an : ans) {
            System.out.println(an);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 队列右端入，保证单调性
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            // 把当前元素的下标装入单调队列
            deque.addLast(i);
            // 判断队列的左端点是否超出窗口的大小
            int left = i - k + 1;
            if(deque.getFirst() < left){
                deque.removeFirst();
            }
            if(left >= 0){
                ans[left] = nums[deque.getFirst()];
            }
        }
        return ans;
    }
}
