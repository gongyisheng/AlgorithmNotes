package graph;

import java.util.*;

//Time Complexity: O(ElogE)
//Space Complexity: O(V+E)
//V: Vertices, E: Edges

public class Dijkstra {
    //build graph
    private static int n;
    private static int[][] graph;
    public static void buildGraph(int vertice,int[][] edges,int[] weight){
        n = vertice;
        graph = new int[n][n];
        for(int i=0;i< edges.length;i++){
            graph[edges[i][0]][edges[i][1]] = weight[i];
        }
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
            if(v==end){
                return d;
            }
            if(visited.contains(v)){
                continue;
            }
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
        //We create two int list and a pq here.
        //int list to record min distance and stops and pq to record edges to unvisited nodes with min dist.
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->a[0]-b[0]);

        // Shortest distances array
        int[] distances = new int[n];

        // Shortest steps array
        int[] currentStops = new int[n];
        //Set default distance and stop to infinite
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);

        distances[start] = 0;
        currentStops[start] = 0;
        //The PriorityQueue will contain (distance,node,step);
        pq.offer(new int[]{0,start,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int v = curr[1];
            int s = curr[2];

            if(s>stepLimit){
                continue;
            }
            if(v==end){
                return d;
            }

            for(int i=0;i<n;i++){
                if(graph[v][i]>0){
                    int dU = d;
                    int dV = distances[i];
                    int wUV = graph[v][i];
                    //better distance?
                    if(dU+wUV<dV){
                        pq.offer(new int[]{dU+wUV,i,s+1});
                        distances[i] = dU+wUV;
                    }//better stops?
                    else if(s<currentStops[i]){
                        pq.offer(new int[]{dU+wUV,i,s+1});
                    }
                    currentStops[i] = s;
                }
            }
        }
        return stepLimit==0||distances[end]==Integer.MAX_VALUE? -1:distances[end];
    }
}
