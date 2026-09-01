package com.javaup;

public class Number138 {

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        for(Node cur = head; cur != null; cur = cur.next.next){
            cur.next = new Node(cur.val,cur.next);
        }

        for(Node cur = head; cur != null; cur = cur.next.next){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
        }

        Node dummy = new Node(0);
        Node tail = dummy;
        for(Node cur = head; cur != null; cur = cur.next,tail = tail.next){
            Node copy = cur.next;
            tail.next  =copy;
            cur.next = copy.next;
        }
        return dummy.next;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val,Node next) {
            this.val = val;
            this.next = next;
            this.random = null;
        }
    }
}
