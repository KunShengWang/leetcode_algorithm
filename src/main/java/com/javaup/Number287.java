package com.javaup;

public class Number287 {

    public static void main(String[] args) {
        int ans = findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(ans);
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        int head = 0;
        while(head != slow){
            slow = nums[slow];
            head = nums[head];
        }
        return slow;
    }
}
