package com.javaup.linked_list;

public class Number234 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode listNode = buildLinkedList(nums);
        boolean ans = isPalindrome(listNode);
        System.out.println(ans);
    }

    public static boolean isPalindrome(ListNode head) {
        // 找中间节点
        ListNode middleNode = getMiddleNode(head);
        // 把中间节点之后的链表反转
        ListNode head2 = reverseList(middleNode);
        while(head2 != null){
            if(head.val != head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
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

    /**
     * 找中间节点
     */
    private static ListNode getMiddleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
