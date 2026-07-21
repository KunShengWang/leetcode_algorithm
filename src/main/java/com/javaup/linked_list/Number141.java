package com.javaup.linked_list;

public class Number141 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode head = buildLinkedList(nums,-1);
        boolean ans = hasCycle(head);
        System.out.println(ans);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 构建完整链表
     */
    private static ListNode buildLinkedList(int[] nums,int pos){
        ListNode head = new ListNode(nums[0]);
        ListNode r = head;
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            r.next = new ListNode(nums[i]);
            r = r.next;
            if(i == pos){
                p = r;
            }
        }
        if(pos != -1){
            r.next = p;
        }
        return head;
    }

    public static class ListNode{

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}
