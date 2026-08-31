package com.javaup;

public class Number206 {

    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode x = head;
        ListNode y = x.next;
        ListNode r = y.next;
        x.next = null;
        while(y != null){
            y.next = x;
            x = y;
            y = r;
            if(r != null){
                r = r.next;
            }
        }
        return x;
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
