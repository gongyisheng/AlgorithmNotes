package com.orange_yishenggong.algorithm_notes.heap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {
    Random random;
    List<Integer> list;
    @BeforeEach
    void setUp() {
        random = new Random(System.currentTimeMillis()%1442968193);
        list = new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(random.nextInt());
        }
    }

    @AfterEach
    void tearDown() {
        random = null;
        list = null;
    }
    @Test
    void heapTest(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        MinHeap minHeap = new MinHeap(list.size());
        for(Integer num:list){
            pq.offer(num);
            minHeap.offer(num);
        }
        while(!pq.isEmpty()){
            assertEquals(pq.poll(),minHeap.poll());
        }
    }
}