package com.javaup.linked_list;

public class Number24 {

    public static void main(String[] args) {
        int[] nums = new int[]{};
        ListNode listNode = buildLinkedList(nums);
        ListNode ans = swapPairs(listNode);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode node0 = dummy;
        ListNode node1 = head;
        while(node1 != null && node1.next != null){
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            node0.next = node2;
            node2.next = node1;
            node1.next = node3;
            node0 = node1;
            node1 = node3;
        }
        return dummy.next;
    }

    /**
     * 构建完整链表
     */
    private static ListNode buildLinkedList(int[] nums){
        if(nums.length == 0){
            return null;
        }
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
            this.val = val;
            this.next = next;
        }
    }
}
