package com.javaup;

public class Number142 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode r = head;
                while(r != slow){
                    r = r.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
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
