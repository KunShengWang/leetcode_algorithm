package com.javaup;

import java.util.HashMap;
import java.util.Map;

public class Number146 {

    public static void main(String[] args) {

    }

    public static class LRUCache{

        public static class Node{
            int key;
            int value;
            Node prev;
            Node next;

            public Node(){}

            public Node(int key,int value){
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Node dummy = new Node(0,0);
        private final Map<Integer,Node> map = new HashMap<>();

        public LRUCache(int capacity){
            this.capacity = capacity;
            dummy.prev = dummy;
            dummy.next = dummy;
        }

        public int get(int key){
            Node node = getKey(key);
            return node == null ? -1 : node.value;
        }

        public void put(int key, int value) {
            Node node = getKey(key);
            if(node != null){
                node.value = value;
                return;
            }
            Node newNode = new Node(key,value);
            pushFront(newNode);
            map.put(key,newNode);
            if(map.size() > capacity){
                Node cur = dummy.prev;
                remove(cur);
                map.remove(cur.key);
            }
        }

        public Node getKey(int key){
            if(!map.containsKey(key)){
                return null;
            }
            Node node = map.get(key);
            remove(node);
            pushFront(node);
            return node;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void pushFront(Node node){
            node.next = dummy.next;
            dummy.next.prev = node;
            node.prev = dummy;
            dummy.next = node;
        }
    }
}
