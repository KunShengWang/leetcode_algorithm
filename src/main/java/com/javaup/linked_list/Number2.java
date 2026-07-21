package com.javaup.linked_list;

public class Number2 {

    public static void main(String[] args) {
        int[] numsA = new int[]{2,4,3};
        int[] numsB = new int[]{5,6,4};
        ListNode listNodeA = buildLinkedList(numsA);
        ListNode listNodeB = buildLinkedList(numsB);
        ListNode ans = addTwoNumbers(listNodeA, listNodeB);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;// 进位值
        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            cur = cur.next = new ListNode(sum % 10);
            carry = sum / 10;
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

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
