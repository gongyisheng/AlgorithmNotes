package graph;

import java.util.*;

public class TopologicalSort {
    static class GNode {
        int inDegree;
        List<Integer> outNodes;
        public GNode (){
            inDegree = 0;
            outNodes = new ArrayList<>();
        }
    }
    public static boolean hasCircle(int[][] graph){
        //build the graph
        Map<Integer,GNode> nodeMap = new HashMap<>();
        for (int[] ints : graph) {
            nodeMap.putIfAbsent(ints[0], new GNode());
            nodeMap.putIfAbsent(ints[1], new GNode());
            GNode from = nodeMap.get(ints[0]);
            GNode to = nodeMap.get(ints[1]);
            from.outNodes.add(ints[1]);
            to.inDegree++;
        }

        //find the origin nodes with zero inDegree

        //using queue here will be bfs, using stack here will be dfs
        Queue<Integer> q = new LinkedList<>();
        for(Integer key:nodeMap.keySet()){
            if(nodeMap.get(key).inDegree==0){
                q.offer(key);
            }
        }

        int removedEdge = 0;
        //backtrack
        //cut off the inDegree, while inDegree==0, add to the queue/stack
        while(!q.isEmpty()){
            GNode from = nodeMap.get(q.poll());
            for(Integer child:from.outNodes){
                GNode to = nodeMap.get(child);
                removedEdge++;
                to.inDegree--;
                if(to.inDegree==0){
                    q.offer(child);
                }
            }
        }
        //if has circle, count will be less than graph.length
        return removedEdge != graph.length;
    }
}
