package com.javaup.linked_list;

public class Number160 {

    public static void main(String[] args) {
        int intersectVal = 8;
        int[] numsA = new int[]{4,1,8,4,5};
        int[] numsB = new int[]{5,6,1,8,4,5};
        int skipA = 2;
        int skipB = 3;
        // 构建完整链表 A
        ListNode listNodeA = buildLinkedList(numsA);
        // 获取 A 中的公共节点
        ListNode commonNode = getNode(listNodeA,skipA);
        // 构建 B 独有的链表，然后接到公共节点上
        ListNode listNodeB = buildPreLinkedList(numsB,skipB,commonNode);
        ListNode ans = getIntersectionNode(listNodeA,listNodeB);
        System.out.println(ans.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while(p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
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

    /**
     * 获取某个位置的节点
     */
    private static ListNode getNode(ListNode head,int pos){
        int count = 0;
        ListNode r = head;
        while(count < pos){
            r = r.next;
            count++;
        }
        return r;
    }

    /**
     * 构建独有的链表，然后接到公共节点上
     */
    private static ListNode buildPreLinkedList(int[] nums,int pos,ListNode commonNode){
        ListNode head = new ListNode(nums[0]);
        ListNode r = head;
        for (int i = 1; i < pos; i++) {
            r.next = new ListNode(nums[i]);
            r = r.next;
        }
        r.next = commonNode;
        return head;
    }


    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }
}
