package com.javaup;

public class Number160 {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode x = headA;
        ListNode y = headB;
        while(x != y){
            x = x == null ? headB : x.next;
            y = y == null ? headA : y.next;
        }
        return x;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
}
