package com.javaup;

public class Number148 {

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode head1 = finMiddleNode(head);
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(head1);
        return mergeTwoLists(node1,node2);
    }

    private ListNode finMiddleNode(ListNode head){
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

    private ListNode mergeTwoLists(ListNode headA,ListNode headB){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(headA != null && headB != null){
            if(headA.val <= headB.val){
                cur.next = headA;
                headA = headA.next;
            }else {
                cur.next = headB;
                headB = headB.next;
            }
            cur = cur.next;
        }
        cur.next = headA == null ? headB : headA;
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
