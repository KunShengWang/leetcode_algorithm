package com.javaup;

public class Number234 {

    public static void main(String[] args) {


    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode cur = slow;
        ListNode pre = null;
        while (cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        while(pre != null){
            if(pre.val != head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
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
