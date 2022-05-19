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
    private final int CUT_VERTEX = 0;
    private final int BRIDGE = 1;
    /**
     * dfn: visit timestamp
     * low: low-link value
     **/
    private int[] dfn;
    private int[] low;
    int time = 1;

    private List<int[]> bridgeAns;
    private List<Integer> cutVertexAns;

    private void dfs(int curr, int prev, int type){
        dfn[curr] = low[curr] = time++;
        for (int next = 0; next < n; next++) {
            if(!graph[curr][next]){
                continue;
            }
            // unvisited
            if (dfn[next] == UNVISITED) {
                dfs(next, curr, type);
                low[curr] = Math.min(low[curr], low[next]);
                switch(type) {
                    case CUT_VERTEX:
                        if(low[next] >= dfn[curr]){
                            cutVertexAns.add(curr);
                        }
                        break;
                    case BRIDGE:
                        if(low[next] > dfn[curr]){
                            bridgeAns.add(new int[]{curr, next});
                        }
                        break;
                    default:
                        break;
                }
            }
            // visited
            else if (next != prev){
                low[curr] = Math.min(low[curr], dfn[next]);
            }
        }
    }
    public List<int[]> getBridge() {
        dfn = new int[n];
        low = new int[n];
        bridgeAns = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(dfn[i]==UNVISITED){
                dfs(i,0, BRIDGE);
            }
        }
        return bridgeAns;
    }
    public List<Integer> getCutVertex() {
        dfn = new int[n];
        low = new int[n];
        cutVertexAns = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(dfn[i]==UNVISITED){
                dfs(i,0, CUT_VERTEX);
            }
        }
        return cutVertexAns;
    }
}
