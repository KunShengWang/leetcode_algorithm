package com.javaup;

public class Number24 {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode n0 = dummy;
        ListNode n1 = head;
        while(n1 != null && n1.next != null){
            ListNode n2 = n1.next;
            ListNode n3 = n2.next;
            n0.next = n2;
            n2.next = n1;
            n1.next = n3;
            n0 = n1;
            n1 = n3;
        }
        return dummy.next;
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
