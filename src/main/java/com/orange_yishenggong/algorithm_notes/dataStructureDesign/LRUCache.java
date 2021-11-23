package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import java.util.HashMap;
import java.util.Map;

//Implement the LRUCache class:
//
//1.LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//2.int get(int key) Return the value of the key if the key exists, otherwise return -1.
//3.void put(int key, int value) Update the value of the key if the key exists.
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
//evict the least recently used key.
//4.The functions get and put run in O(1) average time complexity.

class LRUCache {
    //Node for DoubleLinkList
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    private Node popTail(){
        Node toPop = tail.prev;
        removeNode(toPop);
        return toPop;
    }


    private Map<Integer,Node> cache;
    //current size of double linked list
    private int size;
    //maximum size of cache
    private int capacity;
    //dummy head and tail
    private Node head,tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node==null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        //if it's a new node, add it.
        if(node==null){
            node = new Node();
            node.key = key;
            node.value = value;

            cache.put(key,node);
            addNode(node);
            size++;
            //if the size of cache is too big, pop the last one.
            if(size>capacity){
                Node oldNode = popTail();
                cache.remove(oldNode.key);
                size--;
            }
        } else {
            //if it's an old node, update its value and move it to head.
            node.value = value;
            moveToHead(node);
        }
    }
}

