package com.orange_yishenggong.algorithm_notes.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Time Complexity: O(E)
//Space Complexity: O(E)

public class DFS {
    private static List<List<Integer>> path = new ArrayList<>();
    private static void dfs(Map<Integer,List<Integer>> graphMap, int start, int end, List<Integer> currPath, boolean[] visited){
        if(start==end){
            path.add(new ArrayList<>(currPath));
            return;
        }
        List<Integer> list = graphMap.get(start);
        for(int i=0;list!=null&&i<list.size();i++){
            int next = list.get(i);
            if(!visited[next]){
                visited[next] = true;
                currPath.add(next);
                dfs(graphMap,next,end,currPath,visited);
                currPath.remove(currPath.size()-1);
                visited[next] = false;
            }
        }
    }
    public static List<List<Integer>> findPath(int vertices,int[][] edges,int start,int end) {
        //We need a map to build a graph, a visited to recorded visited vertices, a list to record path.
        Map<Integer,List<Integer>> graphMap = new HashMap<>();
        boolean[] visited = new boolean[vertices];
        List<Integer> currPath = new ArrayList<>();

        for(int i=0;i<edges.length;i++) {
            graphMap.putIfAbsent(edges[i][0], new ArrayList<>());
            graphMap.get(edges[i][0]).add(edges[i][1]);
        }

        //Start point has already visited
        visited[0] = true;
        currPath.add(start);
        //making dfs
        dfs(graphMap,start,end,currPath,visited);

        return path;
    }
}
