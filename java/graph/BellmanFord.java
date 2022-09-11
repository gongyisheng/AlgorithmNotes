package graph;


import java.util.Arrays;

//Theorem 1: In a “graph with no negative-weight cycles” with N vertices, the shortest path between any two vertices has at most N-1 edges.
//Theorem 2: In a “graph with negative weight cycles”, there is no shortest path.

//Time Complexity: O(EV)
//Space Complexity: O(V)
//V: Vertices, E: Edges

public class BellmanFord {
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

    public static boolean hasNegativeCircle(){
        long[][] distance = new long[2][n];
        Arrays.fill(distance[0],Integer.MAX_VALUE);
        Arrays.fill(distance[1],Integer.MAX_VALUE);
        //start with a random point
        distance[0][1] = 0;
        distance[1][1] = 0;

        //at most vertices-1 edges for each vertice, the last time is for examine negative circles.
        for(int i=0;i<n;i++){
            boolean existsUpdate = false;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++) {
                    if (graph[j][k] != 0) {
                        long wUV = graph[j][k];
                        long dU = distance[1 - i & 1][j];
                        long dV = distance[i & 1][k];
                        if (dU + wUV < dV) {
                            distance[i & 1][k] = dU + wUV;
                            existsUpdate = true;
                            if(i == n - 1){
                                return true;
                            }
                        }
                    }
                }
            }
            //If have no updates, break the loop ahead of time.
            if(!existsUpdate){
                break;
            }
        }
        return false;
    }
    public static int getMinDist(int start, int end){
        //We use a two long[n] lists to avoid multiple edge adds in one iteration
        long[][] distance = new long[2][n];
        Arrays.fill(distance[0],Integer.MAX_VALUE);
        Arrays.fill(distance[1],Integer.MAX_VALUE);
        //define the start point
        distance[0][start] = 0;
        distance[1][start] = 0;
        //at most vertices-1 edges for each vertice
        for(int i=0;i<n-1;i++){
            boolean existsUpdate = false;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(graph[j][k]!=0){
                        long wUV = graph[j][k];
                        long dU = distance[1-i&1][j];
                        long dV = distance[i&1][k];
                        if(dU+wUV<dV){
                            distance[i&1][k] = dU+wUV;
                            existsUpdate = true;
                        }
                    }
                }
            }
            //If have no updates, break the loop ahead of time.
            if(!existsUpdate){
                break;
            }
        }
        return distance[(n-2)&1][end]>=Integer.MAX_VALUE? -1:(int)distance[(n-2)&1][end];
    }
    public static int getMinDistWithinSteps(int start, int end, int stepLimit){
        //We use a two long[n] lists to avoid multiple edge adds in one iteration
        long[][] distance = new long[2][n];
        Arrays.fill(distance[0],Integer.MAX_VALUE);
        Arrays.fill(distance[1],Integer.MAX_VALUE);
        //define the start point
        distance[0][start] = 0;
        distance[1][start] = 0;
        //at most vertices-1 edges for each vertice
        for(int i=0;i<stepLimit;i++){
            boolean existsUpdate = false;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(graph[j][k]!=0){
                        long wUV = graph[j][k];
                        long dU = distance[1-i&1][j];
                        long dV = distance[i&1][k];
                        if(dU+wUV<dV){
                            existsUpdate = true;
                            distance[i&1][k] = dU+wUV;
                        }
                    }
                }
            }
            //If have no updates, break the loop ahead of time.
            if(!existsUpdate){
                break;
            }
        }
        return distance[(stepLimit-1)&1][end]>=Integer.MAX_VALUE? -1:(int)distance[(stepLimit-1)&1][end];
    }
}
