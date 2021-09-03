package com.orange_yishenggong.algorithm_notes.graph;


import java.util.*;

//Hierholzer's Algorithm is used to solve problems of Eulerian path.
//1. Find the beginning point : Random point(Eulerian Circle) or point with 0 indegree(Eulerian Path)
//2. Making dfs with the point. Delete the visited edges.
//3. If the point has no neighbors, push it into a stack.
//4. Poll the points out from the stack then we get the Eulerian path.

//Time Complexity: O(E)
//Space Complexity: O(V+E)

public class Hierholzer {
    public static LinkedList<String> findPath(String[][] edges,String start) {
        LinkedList<String> list = new LinkedList<>();

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] edge : edges){
            if(!map.containsKey(edge[0])) map.put(edge[0], new PriorityQueue<String>());

            map.get(edge[0]).add(edge[1]);
        }

        dfs(list, start, map);

        return list;
    }

    private static void dfs(LinkedList<String> list, String airport, Map<String, PriorityQueue<String>> map){
        while(map.containsKey(airport) && !map.get(airport).isEmpty()){
            dfs(list, map.get(airport).poll(), map);
        }
        list.offerFirst(airport);
    }
}
