package com.example.java8.extra.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkedNode() {}
    }

    private Map<Integer,DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    private void addToHead(DLinkedNode dLinkedNode) {
        dLinkedNode.pre = head;
        dLinkedNode.next = head.next;
        head.next.pre = dLinkedNode;
        head.next = dLinkedNode;
    }

    private void removeHead(DLinkedNode dLinkedNode) {
        dLinkedNode.next.pre = dLinkedNode.pre;
        dLinkedNode.pre.next = dLinkedNode.next;
    }

    private void moveToHead(DLinkedNode dLinkedNode) {
        removeHead(dLinkedNode);
        addToHead(dLinkedNode);
    }

    private DLinkedNode removeTail() {
        DLinkedNode dLinkedNode = tail.pre;
        removeHead(dLinkedNode);
        return dLinkedNode;
    }

}
