package com.javaup.linked_list;

import java.util.HashMap;
import java.util.Map;

public class Number138 {

    public static void main(String[] args) {
        int[] values = {7, 13, 11, 10, 1};
        Integer[] randomIndex = {null, 0, 4, 2, 0};

        Node head = buildList(values, randomIndex);

        System.out.println("原链表：");
        printList(head);

        Node copyHead = copyRandomList(head);

        System.out.println("复制链表：");
        printList(copyHead);
    }

    public static Node copyRandomList(Node head) {
        // 把复制节点插入到原节点之后
        for(Node cur = head; cur != null; cur = cur.next.next){
            cur.next = new Node(cur.val,cur.next);
        }
        // 给复制节点找 random
        for(Node cur = head; cur != null; cur = cur.next.next){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
        }
        // 剖离复制链表
        Node dummy = new Node(0,head);
        Node tail = dummy;
        for(Node cur = head; cur != null; cur = cur.next,tail = tail.next){
            Node copy = cur.next;
            tail.next = copy;
            cur.next = copy.next;
        }
        return dummy.next;
    }

    public static Node buildList(int[] values, Integer[] randomIndex) {
        if (values == null || values.length == 0) {
            return null;
        }

        if (randomIndex == null || values.length != randomIndex.length) {
            throw new IllegalArgumentException(
                    "values 和 randomIndex 的长度必须相同"
            );
        }

        int n = values.length;
        Node[] nodes = new Node[n];

        // 创建节点
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(values[i]);
        }

        // 连接 next
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // 连接 random
        for (int i = 0; i < n; i++) {
            Integer index = randomIndex[i];

            if (index != null) {
                if (index < 0 || index >= n) {
                    throw new IllegalArgumentException(
                            "random 下标越界：" + index
                    );
                }

                nodes[i].random = nodes[index];
            }
        }

        return nodes[0];
    }

    public static void printList(Node head) {
        // 节点对象 -> 下标
        Map<Node, Integer> indexMap = new HashMap<>();

        int index = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            indexMap.put(cur, index++);
        }

        for (Node cur = head; cur != null; cur = cur.next) {
            Integer randomIndex = indexMap.get(cur.random);

            System.out.println(
                    "val = " + cur.val +
                            ", randomIndex = " + randomIndex
            );
        }
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
