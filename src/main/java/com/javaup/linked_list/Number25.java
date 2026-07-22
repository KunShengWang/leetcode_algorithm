package com.javaup.linked_list;

public class Number25 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode listNode = buildLinkedList(nums);
        ListNode ans = reverseKGroup(listNode,2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    /**
     * 思路就是先按 k 个长度的节点进行翻转；然后再把翻转的链表接入完整链表
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表长度
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;
        ListNode cur = p0.next;
        ListNode pre = null;
        for ( ; n >= k ; n -= k) {// 剩余的长度需要大于或者等于要翻转的长度，不要剩余的部分就保持不变
            // 按 k 个长度的节点进行翻转
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            // 把翻转的链表接入完整链表
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
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

    public static class ListNode{

        int val;

       ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
