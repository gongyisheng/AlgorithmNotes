package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeListTest {
    RangeList rangeList;

    @BeforeEach
    void setUp() {
        this.rangeList = new RangeList();
    }

    @AfterEach
    void tearDown() {
        this.rangeList = null;
    }
    @Test
    void classTest(){
        rangeList.add(1,5);
        assertEquals(rangeList.print(),"[1,5)");
        rangeList.add(10,20);
        assertEquals(rangeList.print(),"[1,5),[10,20)");
        rangeList.add(20,20);
        assertEquals(rangeList.print(),"[1,5),[10,20)");
        rangeList.add(20,21);
        assertEquals(rangeList.print(),"[1,5),[10,21)");
        rangeList.add(2,4);
        assertEquals(rangeList.print(),"[1,5),[10,21)");
        rangeList.add(3,8);
        assertEquals(rangeList.print(),"[1,8),[10,21)");
        rangeList.remove(10,10);
        assertEquals(rangeList.print(),"[1,8),[10,21)");
        rangeList.remove(10,11);
        assertEquals(rangeList.print(),"[1,8),[11,21)");
        rangeList.remove(15,17);
        assertEquals(rangeList.print(),"[1,8),[11,15),[17,21)");
        rangeList.remove(3,19);
        assertEquals(rangeList.print(),"[1,3),[19,21)");
    }
}