package com.orange_yishenggong.algorithm_notes.graph;

import com.orange_yishenggong.algorithm_notes.graph.util.Graph;

import java.util.ArrayList;
import java.util.List;

public class Tarjan extends Graph {
    public Tarjan(int vertice, int[][] edges, boolean isDirected) {
        super(vertice, edges, isDirected);
    }

    public Tarjan(int vertice, int[][] edges, boolean isDirected, int[][] weights) {
        super(vertice, edges, isDirected, weights);
    }

    private final int UNVISITED = 0;
    /**
     * dfn: visit timestamp
     * low: low-link value
     **/
    private int[] dfn;
    private int[] low;
    int time = 1;

    private List<int[]> ans;

    private void dfs(int curr, int prev){
        dfn[curr] = low[curr] = time++;
        for (int next = 0; next < n; next++) {
            if(!graph[curr][next]){
                continue;
            }
            // unvisited
            if (dfn[next] == UNVISITED) {
                dfs(next, curr);
                low[curr] = Math.min(low[curr], low[next]);
            }
            // visited
            else if (next != prev){
                low[curr] = Math.min(low[curr], dfn[next]);
            }
            if(low[next] > dfn[curr]){
                ans.add(new int[]{curr, next});
            }
        }
    }
    public List<int[]> getBridge() {
        dfn = new int[n];
        low = new int[n];
        ans = new ArrayList<>();
        dfs(0,-1);
        return ans;
    }
}
