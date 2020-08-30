package com.example.java8.extra.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class A {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode pre = new ListNode(1);
        pre.next = new ListNode(2);
        ListNode cur0 = pre;
        ListNode cur1 = pre.next;
        pre.next = new ListNode(3);
        log.info(String.valueOf(cur0.next.val) + "pre:" + String.valueOf(pre.next.val) );
        log.info(String.valueOf(cur1.val));
    }
}
