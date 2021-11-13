package com.orange_yishenggong.algorithm_notes.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private int[] list1 = {1,2,3,4,5,6,7,8};
    private int[] list2 = {1,1,2,3,4,5,6,7,8};
    private int[] list3 = {1,1,2,2,2,2,3,3,3};
    @Test
    void search() {
        BinarySearch bs = new BinarySearch(list1);
        assertEquals(0,bs.search(1));
        assertEquals(1,bs.search(2));
    }

    @Test
    void left_bound() {
        BinarySearch bs = new BinarySearch(list2);
        assertEquals(0,bs.left_bound(0));
    }

    @Test
    void right_bound() {
        BinarySearch bs = new BinarySearch(list3);
        assertEquals(0,bs.right_bound(1));
    }
}