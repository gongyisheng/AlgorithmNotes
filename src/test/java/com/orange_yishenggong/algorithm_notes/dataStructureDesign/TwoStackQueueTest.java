package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TwoStackQueueTest {
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
    void queueTest(){
        Queue<Integer> q1 = new LinkedList<>();
        TwoStackQueue q2 = new TwoStackQueue();
        for(Integer num:list){
            q1.offer(num);
            q2.offer(num);
            assertEquals(q1.peek(),q2.peek());
        }
        while(!q1.isEmpty()){
            assertEquals(q1.peek(),q2.peek());
            assertEquals(q1.poll(),q2.poll());
        }
    }
}