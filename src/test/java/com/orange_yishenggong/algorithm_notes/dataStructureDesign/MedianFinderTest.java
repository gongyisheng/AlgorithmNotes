package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    MedianFinder mf;
    @BeforeEach
    void setUp() {
        mf = new MedianFinder();
    }

    @AfterEach
    void tearDown() {
        mf = null;
    }

    @Test
    void classTest1() {
        mf.addNum(1);
        assertEquals(1,mf.findMedian());
        mf.addNum(2);
        assertEquals(1.5,mf.findMedian());
        mf.addNum(3);
        assertEquals(2.0,mf.findMedian());
    }
    @Test
    void classTest2() {
        mf.addNum(3);
        assertEquals(3.0,mf.findMedian());
        mf.addNum(2);
        assertEquals(2.5,mf.findMedian());
        mf.addNum(1);
        assertEquals(2.0,mf.findMedian());
    }
}