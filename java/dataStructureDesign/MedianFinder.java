package dataStructureDesign;

import java.util.PriorityQueue;

/**
 * Description:
 * Build a data structure to help find median from data stream
 *
 * Complexity Analysis:
 * Time Complexity: O(logN) for addNum, O(1) for findMedian
 * Space Complexity: O(N)
 *
 * Thoughts:
 * 1.Brutal force with simple sort, find the median with index.
 * 2.Linkedlist for adding numbers, find the median with binary search.
 * 3.Focus on median: two heaps solution
 */

public class MedianFinder {

    PriorityQueue<Integer> max;//left one
    PriorityQueue<Integer> min;//right one

    public MedianFinder() {
        max = new PriorityQueue<Integer>((a,b)->(b-a));
        min = new PriorityQueue<Integer>((a,b)->(a-b));
    }

    public void addNum(int num){
        min.offer(num);
        max.offer(min.poll());
        if(min.size() < max.size()){
            min.offer(max.poll());
        }
    }

    public double findMedian() {
        if(min.isEmpty()){
            return -1.0;
        }
        if(min.size()==max.size()){
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return min.peek();
        }
    }
}