package com.orange_yishenggong.algorithm_notes.graph;

import java.util.*;

//                   Build graph || Detect Circle | Determine Reachable | Find Path
//Time Complexity:      O(E)                    O(Bf^Dtree)
//Space Complexity:     O(V+E)                  O(Bf*Dtree)

//V: Vertices, E: Edges
//Bf: Branch Factor, Dtree:Depth of Tree

public class DFS {
    private static Map<Integer,List<Integer>> graphMap;
    public static void buildGraph(int[][] edges) {
        //We need a map to build a graph
        graphMap = new HashMap<>();

        for(int i=0;i<edges.length;i++) {
            graphMap.putIfAbsent(edges[i][0], new ArrayList<>());
            graphMap.get(edges[i][0]).add(edges[i][1]);
        }
    }

    //Detect Circle
    private static boolean hasCircle = false;
    private static void dfs_hasCircle(int curr,Map<Integer,Integer> status){
        if(hasCircle) return;
        //We only need unvisited nodes
        if(status.containsKey(curr)){
            //When we find the curr status is visiting, the graph has a circle.
            if(status.get(curr)==1)
                hasCircle = true;
            return;
        }
        //Set the status to 1: visiting
        status.put(curr,1);
        List<Integer> currList = graphMap.get(curr);
        if(currList!=null&&!currList.isEmpty()) {
            for(Integer next:currList) {
                dfs_hasCircle(next,status);
            }
        }
        //Set the status to 2: visited
        status.put(curr,2);
    }
    public static boolean hasCircle(){
        Map<Integer,Integer> status = new HashMap<>();
        for(Integer key:graphMap.keySet()){
            if(!status.containsKey(key))
                dfs_hasCircle(key,status);
        }
        return hasCircle;
    }
    //Determine Reachable
    public static boolean reachable = false;
    private static void dfs_isReachable(int curr,int target,Set<Integer> visited){
        if(reachable||visited.contains(curr)) return;
        if(curr==target){
            reachable = true;
            return;
        }
        //add the node to visited
        visited.add(curr);
        List<Integer> currList = graphMap.get(curr);
        if(currList!=null&&!currList.isEmpty()){
            for(Integer next:currList){
                dfs_isReachable(next,target,visited);
            }
        }
    }
    public static boolean isReachable(int from,int to){
        Set<Integer> visited = new HashSet<>();
        dfs_isReachable(from,to,visited);
        return reachable;
    }

    //Find Path
    private static List<List<Integer>> path = new ArrayList<>();
    private static void dfs_findPath(int start, int end, List<Integer> currPath, Set<Integer> visited){
        if(start==end){
            path.add(new ArrayList<>(currPath));
            return;
        }
        List<Integer> list = graphMap.get(start);
        for(int i=0;list!=null&&i<list.size();i++){
            int next = list.get(i);
            if(!visited.contains(next)){
                visited.add(next);
                currPath.add(next);
                dfs_findPath(next,end,currPath,visited);
                currPath.remove(currPath.size()-1);
                visited.remove(next);
            }
        }
    }
    public static List<List<Integer>> findPath(int start,int end){
        //We need a visited to recorded visited vertices, a list to record path.
        Set<Integer> visited = new HashSet<>();
        List<Integer> currPath = new ArrayList<>();

        //Start point has already visited
        visited.add(0);
        currPath.add(start);
        //making dfs
        dfs_findPath(start,end,currPath,visited);
        return path;
    }
}
