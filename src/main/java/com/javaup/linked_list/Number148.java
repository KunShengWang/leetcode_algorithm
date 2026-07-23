package com.javaup.linked_list;

public class Number148 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1,3};
        ListNode node = buildLinkedList(nums);
        ListNode ans = sortList(node);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 从链表中间节点处分为两个小的链表
        ListNode head2 = middleNode(head);
        head = sortList(head);
        head2 = sortList(head2);
        // 合并有序链表
        return mergeTwoLists(head,head2);
    }

    private static ListNode middleNode(ListNode head){
        ListNode pre = new ListNode(0,head);
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        return slow;
    }

    /**
     * 合并两个有序链表
     */
    private static ListNode mergeTwoLists(ListNode head, ListNode head2){
        ListNode dummy = new ListNode(0,head);
        ListNode p = dummy;
        while(head != null && head2 != null){
            if(head.val <= head2.val) {
                p.next = head;
                head = head.next;
            }else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if(head != null){
            p.next = head;
        }
        if(head2 != null){
            p.next = head2;
        }
        return dummy.next;
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

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
