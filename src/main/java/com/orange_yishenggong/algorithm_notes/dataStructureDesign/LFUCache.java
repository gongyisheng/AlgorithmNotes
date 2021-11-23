package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import java.util.HashMap;
import java.util.LinkedHashSet;
//                      get    put
//Time Complexity       O(1)   O(1)
//Space Complexity      O(N)   O(N)

public class LFUCache {
    //We need three hashmap here: key-val hashmap, key-freq hashmap and freq-set(key) hashmap.
    //key-val hashmap is used to record key-value
    //key-freq hashmap is used to record the freq of every key
    //key-set(key) hashmap is the reverse one of key-freq hashmap, it is used for performance improvement in remove some elements
    //You may also use key-linkedlist(key) here. But its performance may be bad if there's much hash collision.

    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;

    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
