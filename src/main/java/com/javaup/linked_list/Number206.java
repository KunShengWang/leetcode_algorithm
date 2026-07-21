package com.javaup.linked_list;

public class Number206 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode listNode = buildLinkedList(nums);
        ListNode ans = reverseList(listNode);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = p.next;
        ListNode r = q.next;
        p.next = null;
        while(q != null){
            q.next = p;
            p = q;
            q = r;
            if(r != null){
                r = r.next;
            }
        }
        return p;
    }

    /**
     * 构建完整链表
     */
    private static ListNode buildLinkedList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode r = head;
        for (int i = 1; i < nums.length; i++) {
            r.next = new ListNode(nums[i]);
            r = r.next;
        }
        return head;
    }

    public static class ListNode{
        
        int val;
        
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
