package com.orange_yishenggong.algorithm_notes.linkedList;

class DoubleNode {
    int val;
    DoubleNode prev;
    DoubleNode next;

    public DoubleNode() {}

    public DoubleNode(int val) {
        this.val = val;
    }

    public DoubleNode(int val, DoubleNode prev, DoubleNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

public class DoubleLinkedList {
    public DoubleNode reverse(DoubleNode head){
        DoubleNode prev = null;
        DoubleNode next = null;
        while(head!=null){
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }
    public void remove(DoubleNode node){
        DoubleNode prev = node.prev;
        DoubleNode next = node.next;
        next.prev = prev;
        prev.next = next;
    }

}
