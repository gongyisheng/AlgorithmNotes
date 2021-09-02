package com.orange_yishenggong.algorithm_notes.graph;

import java.util.Arrays;

//Time Complexity: O(ElogE)
//Space Complexity: O(V)
//E:edges,V:vertices

public class Kruskal {
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
        Edge[] edges = new Edge[num*(num-1)/2];
        int count = 0;
        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                //perform manhattan distance here as an example
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                Edge edge = new Edge(i,j,dist);
                edges[count] = edge;
                count++;
            }
        }
        return minCostWithEdges(num,edges);
    }
    public static int minCostWithEdges(int vertices,Edge[] edges){
        //using union and find to make sure there's no circle during building the graph
        UF uf = new UF(vertices-1);
        int cost = 0;
        //sort the edges to perform the greedy strategy: edges with min cost to add first
        Arrays.sort(edges,(a,b)->a.cost-b.cost);
        for(Edge edge:edges){
            //only add edges which do not form circles
            if(uf.union(edge.point1,edge.point2))
                cost += edge.cost;
        }
        return cost;
    }
}
