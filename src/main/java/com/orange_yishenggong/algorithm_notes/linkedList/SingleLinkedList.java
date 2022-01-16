package com.orange_yishenggong.algorithm_notes.linkedList;

class SingleNode {
    int val;
    SingleNode next;

    public SingleNode() {}

    public SingleNode(int val) {
        this.val = val;
    }

    public SingleNode(int val, SingleNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SingleLinkedList {
    public SingleNode reverse(SingleNode head){
        SingleNode prev = null;
        SingleNode next = null;
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
