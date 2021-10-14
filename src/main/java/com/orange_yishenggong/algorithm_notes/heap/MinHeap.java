package com.orange_yishenggong.algorithm_notes.heap;

import java.util.Arrays;

//                    insert N values   Popmax one value
//Time complexity:       O(NlogN)            O(logN)
//Space complexity:        O(N)                O(1)

public class MinHeap {
    public int length;
    public int pointer;
    public int[] heap;
    //initialize a heap
    public MinHeap(int length){
        this.length = length;
        heap = new int[length+1];
        Arrays.fill(heap,Integer.MAX_VALUE);
        pointer = 0;
    }
    //parent of index
    public int parent(int root){
        return root/2;
    }

    public int leftChild(int root){
        return root*2;
    }

    public int rightChild(int root){
        return root*2+1;
    }
//  swap two numbers in the heap
    public void swap(int i,int j){
        if(i<=0||j<=0||i>length||j>length) return;
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
//  make a node up.
    public void swim(int root){
        while(root>1&&heap[root]<heap[parent(root)]){
            swap(root,parent(root));
            root = parent(root);
        }
    }
//  make a node down.
    public void sink(int root){
        while(leftChild(root)<=length){
            int index = leftChild(root);
            if(rightChild(root)<=length&&heap[rightChild(root)]<heap[index]){
                index = rightChild(root);
            }
            if(heap[root]<=heap[index]) break;
            swap(root,index);
            root = index;
        }
    }
//  insert it at the end of heap then swim
    public void insert(int num){
        pointer++;
        heap[pointer] = num;
        swim(pointer);
    }
//  swap the first and last num, delete the last num, sink the first num.
    public int popMin(){
        int min = heap[1];
        swap(1,pointer);
        heap[pointer] = Integer.MAX_VALUE;
        pointer--;
        sink(1);
        return min;
    }
}
