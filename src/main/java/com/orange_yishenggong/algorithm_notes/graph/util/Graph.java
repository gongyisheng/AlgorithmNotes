package com.orange_yishenggong.algorithm_notes.graph.util;

/**
 * Build Graph
 * @author Orange Meow
 */
public class Graph {
    public int n;
    public boolean[][] graph;
    public int[][] edges;
    public boolean isDirected;
    private int[][] _weights;
    public int[][] weights;
    public Graph(int vertice, int[][] edges, boolean isDirected){
        this.n = vertice;
        this.edges = edges;
        this.isDirected = isDirected;
        this.graph = new boolean[n][n];
    }

    public Graph(int vertice,int[][] edges, boolean isDirected, int[][] weights){
        this.n = vertice;
        this.edges = edges;
        this.isDirected = isDirected;
        this._weights = weights;
        this.weights = new int[n][n];
        this.graph = new boolean[n][n];
    }

    public void buildGraph(){
        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            this.graph[x][y] = true;
            if(!this.isDirected){
                this.graph[y][x] = true;
            }
        }
    }
    public void buildWeights(){
        for(int[] weight: this._weights){
            int x = weight[0];
            int y = weight[1];
            int w = weight[2];
            this.weights[x][y] = w;
            if(!this.isDirected){
                this.weights[y][x] = w;
            }
        }
    }
}
