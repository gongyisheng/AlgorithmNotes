package com.orange_yishenggong.algorithm_notes.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TarjanTest {
    private int n = 3;
    private int[] caseN = new int[]{4,2,6};
    private int[][][] caseEdges = new int[][][]{
            {{0,1},{1,2},{2,0},{1,3}},
            {{0,1},{1,0}},
            {{0,1},{1,2},{2,0},{1,3},{3,4},{4,5},{5,3}},
    };
    private int[][][] caseBridgeResult = new int[][][]{
            {{1,3}},
            {{0,1}},
            {{1,3}},
    };
    private int[][] caseCutVertexResult = new int[][]{
            {1},
            {0,1},
            {1,3},
    };

    private int[][] _bridgeListToArray(List<int[]> list){
        int[][] array = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
    }

    private int[] _cutVertexListToArray(List<Integer> list){
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
    }

    @Test
    void getBridge() {
        for(int i = 0; i < n; i++) {
            int vertice = caseN[i];
            int[][] edges = caseEdges[i];
            Tarjan tarjan = new Tarjan(vertice,edges,true);
            tarjan.buildGraph();
            List<int[]> list = tarjan.getBridge();
            assertArrayEquals(caseBridgeResult[i], _bridgeListToArray(list));
        }
    }

    @Test
    void getCutVertex() {
        for(int i = 2; i < n; i++){
            int vertice = caseN[i];
            int[][] edges = caseEdges[i];
            Tarjan tarjan = new Tarjan(vertice,edges,true);
            tarjan.buildGraph();
            List<Integer> list = tarjan.getCutVertex();
            System.out.println(list);
            System.out.println(i);
            assertArrayEquals(caseCutVertexResult[i], _cutVertexListToArray(list));
        }
    }
}