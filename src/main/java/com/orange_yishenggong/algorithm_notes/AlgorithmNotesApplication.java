package com.orange_yishenggong.algorithm_notes;

import com.orange_yishenggong.algorithm_notes.graph.*;
import com.orange_yishenggong.algorithm_notes.tests.ts;
import com.orange_yishenggong.algorithm_notes.tests.uf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmNotesApplication {
    private static int[][] graph1 = new int[][]{{1,0},{1,2},{2,3},{3,4},{1,4},{5,2},{2,6}};//has circle;
    private static int[][] graph2 = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
    private static int[][] points1 = new int[][]{{3,12},{-2,5},{-4,1}};
    private static String[][] tickets = new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
    public static void main(String[] args) {
        SpringApplication.run(AlgorithmNotesApplication.class, args);
//        System.out.println(TopologicalSort.hasCircle(graph1));
//        System.out.println(UnionFind.findRedundantConnection(graph2));
//        System.out.println(uf.test(graph2));
//        System.out.println(Kruskal.minCostWithPoints(points1));
//        System.out.println(Prim.minCostWithPoints(points1));
        DFS test = new DFS();
        test.buildGraph(graph1);
        System.out.println(DFS.hasCircle());
        System.out.println(DFS.isReachable(1,6));
        System.out.println(DFS.findPath(1,6));
//        System.out.println(Hierholzer.findPath(tickets,"JFK"));
    }
}
