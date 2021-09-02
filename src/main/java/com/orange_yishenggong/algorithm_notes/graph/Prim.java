package com.orange_yishenggong.algorithm_notes.graph;

import java.util.PriorityQueue;

//Time Complexity: Binary heap: O(ElogV),Fibonacci heap: O(E+VlogV)
//Space Complexity: O(V);
//E:edges,V:vertices

public class Prim {
    static class Edge {

        int point1;
        int point2;
        int cost;
        public Edge(int p1,int p2,int cost){
            this.point1 = p1;
            this.point2 = p2;
            this.cost = cost;
        }
    }
    public static int minCostWithPoints(int[][] points){
        int num = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean[] visited = new boolean[num];
        int edgeNum = 0;
        int cost = 0;

        //build the graph with random points first(Here choose 0 point as an example)
        for(int i=1;i<num;i++){
            int dist = Math.abs(points[0][0]-points[i][0])+Math.abs(points[0][1]-points[i][1]);
            Edge edge = new Edge(0,i,dist);
            pq.offer(edge);
        }
        visited[0] = true;

        //Points can be divided into two groups here: visited and haven't visited
        //poll the edge with min cost among the two groups
        while(!pq.isEmpty()&&edgeNum<num-1){
            Edge edge = pq.poll();
            int p = edge.point2;
            if(!visited[p]){
                cost += edge.cost;
                visited[p] = true;
                //now p has turned into a visited point
                //add all the edges to the points which haven't visited, sort them by distance.
                for(int i=0;i<num;i++){
                    if(!visited[i]){
                        int dist = Math.abs(points[p][0]-points[i][0])+Math.abs(points[p][1]-points[i][1]);
                        pq.offer(new Edge(p,i,dist));
                    }
                }
                //plus the count of edges, we only need N-1 edges to build a MST
                edgeNum++;
            }
        }
        return cost;
    }
}
