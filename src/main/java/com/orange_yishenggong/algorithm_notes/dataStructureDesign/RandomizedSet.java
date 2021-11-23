package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import java.util.*;

/**
 * Time Complexity: O(1) for insert, remove and getRandom()
 * Space Complexity:O(N)
 *
 * Thoughts:
 * 1.No duplicates: HashMap/HashSet
 * 2.getRandom() in O(1): List with randomized index
 * 3.insert, remove in O(1): ArrayList+HashMap(to store index of which to delete without searching)
 */


public class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        dict = new HashMap();
        list = new ArrayList();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val)) return false;

        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (! dict.containsKey(val)) return false;

        // move the last element to the place idx of the element to delete
        int lastElement = list.get(list.size() - 1);
        int idx = dict.get(val);
        list.set(idx, lastElement);
        dict.put(lastElement, idx);
        // delete the last element
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
