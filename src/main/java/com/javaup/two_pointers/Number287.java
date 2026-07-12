package com.javaup.two_pointers;

public class Number287 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        int ans = findDuplicate(nums);
        System.out.println(ans);
    }

    /**
     * 本题关键：下一个节点 = nums[当前节点]
     * 把数组看做是链表
     */
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 找快慢指针的相遇处
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
