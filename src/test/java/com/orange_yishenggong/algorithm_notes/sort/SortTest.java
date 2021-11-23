package com.orange_yishenggong.algorithm_notes.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
    private int[][] testArrs = new int[][]{
            {1,6,2,4,8,2,19,4309,2345,193,567,934,582},
            {2,10,3,40,20,485,1293,-19,0,0,0,2,2,2,3,4,5,6},
            {0,0,0,0,0,0,0,0},
            {0},
            {1,2}
    };
    @Test
    void bubbleSort() {
        for(int[] arr:testArrs) {
            Sort s = new Sort(arr);
            assertArrayEquals(s.bubbleSort(), s.builtInSort());
        }
    }

    @Test
    void selectionSort() {
        for(int[] arr:testArrs) {
            Sort s = new Sort(arr);
            assertArrayEquals(s.selectionSort(),s.builtInSort());
        }
    }

    @Test
    void insertionSort() {
        for(int[] arr:testArrs) {
            Sort s = new Sort(arr);
            assertArrayEquals(s.insertionSort(),s.builtInSort());
        }
    }

    @Test
    void mergeSort() {
        for(int[] arr:testArrs) {
            Sort s = new Sort(arr);
            assertArrayEquals(s.mergeSort(),s.builtInSort());
        }
    }

    @Test
    void quickSort() {
        for(int[] arr:testArrs) {
            Sort s = new Sort(arr);
            assertArrayEquals(s.quickSort(),s.builtInSort());
        }
    }
}