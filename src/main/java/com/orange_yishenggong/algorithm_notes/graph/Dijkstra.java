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
    private static Map<Integer,List<Edge>> graph = new HashMap<>();
    public static void buildGraph(int vertice,int[][] edges,int[] weight){
        n = vertice;
        for(int i=0;i< edges.length;i++){
            graph.putIfAbsent(edges[i][0],new ArrayList<>());
            graph.get(edges[i][0]).add(new Edge(edges[i][0],edges[i][1],weight[i]));
        }
    }

    public static int getMinDist(int start,int end){
        //We create a hashSet and a pq here. hashSet to record visited nodes and pq to record edges to unvisited nodes with min dist.
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Vertice> pq = new PriorityQueue<Vertice>((a, b)->a.dist-b.dist);
        pq.offer(new Vertice(start,0));

        while(!pq.isEmpty()){
            //Every time we poll out the edge with min dist
            Vertice curr = pq.poll();
            int v = curr.val;
            int d = curr.dist;
            //find the end
            if(v==end) return d;
            if(visited.contains(v))
                continue;
            visited.add(v);
            if(graph.containsKey(v)){
                for(Edge edge:graph.get(curr.val)){
                    int nei = edge.to;
                    int d2 = edge.weight;
                    //only add unvisited nodes
                    if(!visited.contains(nei)){
                        pq.offer(new Vertice(nei,d+d2));
                    }
                }
            }
        }
        return -1;
    }
}
