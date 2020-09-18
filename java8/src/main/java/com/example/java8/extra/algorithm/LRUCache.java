package com.example.java8.extra.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if(node == null) return -1;
        //先从缓存检索 然后移到表头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node == null) {
            //如果node不存在创建一个新节点，加到头部 然后删除
            DLinkedNode dLinkedNode = new DLinkedNode(key,value);
            map.put(key,dLinkedNode);
            addToHead(dLinkedNode);
            size++;
            if(size > capacity) {
                removeTail();
                map.remove(key);
                --size;
            } else {  //key存在 通过哈希表定位 修改一下value 放到头部
                node.value = value;
                addToHead(node);
            }
        }
    }

    class DLinkedNode {
        int key;
        int value;

        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    private void addToHead(DLinkedNode dLinkedNode) {
        dLinkedNode.next = head.next;
        head.next = dLinkedNode;
        dLinkedNode.prev = head;
        head.next.prev = dLinkedNode;
    }

    private void removeNode(DLinkedNode dLinkedNode) {
        dLinkedNode.prev.next = dLinkedNode.next;
        dLinkedNode.next.prev = dLinkedNode.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(DLinkedNode dLinkedNode) {
        removeNode(dLinkedNode);
        addToHead(dLinkedNode);
    }
}
