package com.javaup.linked_list;

public class Number19 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode listNode = buildLinkedList(nums);
        ListNode ans = removeNthFromEnd(listNode,2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = dummy;
        // 让右端点先走，固定尺子大小
        while(n-- > 0){
            right = right.next;
        }
        // 尺子移动，右端点移动到最右端
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next; // 左指针的下一个节点就是倒数第 n 个节点
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
