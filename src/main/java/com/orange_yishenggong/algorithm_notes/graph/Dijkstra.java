package com.orange_yishenggong.algorithm_notes.graph;

import java.util.*;

//Time Complexity: O(ElogE)
//Space Complexity: O(V+E)
//V: Vertices, E: Edges

public class Dijkstra {
    private static class Vertice{
        int val;
        int dist;
        public Vertice(int v,int d){
            val = v;
            dist = d;
        }
    }
    private static class Edge{
        int from;
        int to;
        int weight;
        public Edge(int f,int t,int w){
            from = f;
            to = t;
            weight = w;
        }
    }
    //build graph
    private static int n;
    private static int[][] graph;
    public static void buildGraph(int vertice,int[][] edges,int[] weight){
        n = vertice;
        graph = new int[n][n];
        for(int i=0;i< edges.length;i++)
            graph[edges[i][0]][edges[i][1]] = weight[i];
    }

    public static int getMinDist(int start,int end){
        //We create a hashSet and a pq here. hashSet to record visited nodes and pq to record edges to unvisited nodes with min dist.
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->a[0]-b[0]);
        //The PriorityQueue will contain (distance,node)
        pq.offer(new int[]{0,start});

        while(!pq.isEmpty()){
            //Every time we poll out the edge with min dist
            int[] curr = pq.poll();
            int d = curr[0];
            int v = curr[1];
            //find the end
            if(v==end) return d;
            if(visited.contains(v))
                continue;
            visited.add(v);
            for(int i=0;i<n;i++){
                if(graph[v][i]>0&&!visited.contains(i)){
                    pq.offer(new int[]{d+graph[v][i],i});
                }
            }
        }
        return -1;
    }

    public static int getMinDistWithinSteps(int start,int end,int stepLimit){
        //We create a hashSet and a pq here. hashSet to record visited nodes and pq to record edges to unvisited nodes with min dist.
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->a[0]-b[0]);
        //The PriorityQueue will contain (distance,node,step);
        pq.offer(new int[]{0,start,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int v = curr[1];
            int s = curr[2];
            if(s>stepLimit)
                continue;
            if(v==end)
                return d;
            for(int i=0;i<n;i++){
                if(graph[v][i]>0&&!visited.contains(i)){
                    pq.offer(new int[]{d+graph[v][i],i,s+1});
                }
            }
        }
        return -1;
    }
}
