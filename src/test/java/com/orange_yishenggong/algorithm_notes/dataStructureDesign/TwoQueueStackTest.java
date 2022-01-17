package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TwoQueueStackTest {
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
    void stackTest(){
        Stack<Integer> stack1 = new Stack<>();
        TwoQueueStack stack2 = new TwoQueueStack();
        for(Integer num:list){
            stack1.push(num);
            stack2.push(num);
            assertEquals(stack1.peek(),stack2.peek());
        }
        while(!stack1.isEmpty()){
            assertEquals(stack1.peek(),stack2.peek());
            assertEquals(stack1.pop(),stack2.pop());
        }
    }
}