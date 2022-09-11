package dataStructureDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/** Description:
 * A data structure returns random number from 0 to K and avoid choosing
 * the number in the blacklist.
 *
 * Complexity Analysis:
 * Time Complexity: O(b) for constructor, O(1) for pick
 * Space Complexity: O(b)
 *
 * Thoughts:
 * 1.If we want to get random integer, we need to maintain a virtual/real list
 * We choose random integers by generating random indexes and look up the value
 * of the indexes in list.
 * 2. To avoid choosing numbers in the blacklist, we need to remove some numbers
 * from the list. To make it run in O(1), we should swap the number we want to
 * remove with the tail and then pop the tail.
 * 3. To make it simpler, we maintain a hashMap to record index-value pair if it's
 * swapped
 */
public class RandomizedSetWithBlacklist {
    private int M;
    private Map<Integer,Integer> map;
    private Random r;

    public RandomizedSetWithBlacklist(int N, int[] blacklist) {
        map = new HashMap<>();
        for (int b : blacklist) // O(B)
            map.put(b, -1);
        M = N - map.size();

        for(int b:blacklist){
            if(b<M){
                while(map.containsKey(N-1)){
                    N--;
                }
                map.put(b,N-1);
                N--;
            }
        }

        r = new Random();
    }

    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }
}
