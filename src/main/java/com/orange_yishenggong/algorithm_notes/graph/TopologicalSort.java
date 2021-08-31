package com.orange_yishenggong.algorithm_notes.graph;

import java.util.*;

class GNode {
    int inDegree;
    List<Integer> outNodes;
    public GNode (){
        inDegree = 0;
        outNodes = new ArrayList<>();
    }
}
class TopologicalSort {
    public boolean hasCircle(int[][] graph){
        //build the graph
        Map<Integer,GNode> nodeMap = new HashMap<>();
        for(int i=0;i<graph.length;i++){
            nodeMap.putIfAbsent(graph[i][0],new GNode());
            nodeMap.putIfAbsent(graph[i][1],new GNode());
            GNode from = nodeMap.get(graph[i][0]);
            GNode to = nodeMap.get(graph[i][1]);
            from.outNodes.add(graph[i][1]);
            to.inDegree++;
        }

        //find the origin nodes with zero inDegree

        //using queue here will be bfs, using stack here will be dfs
        Queue<Integer> q = new LinkedList<>();
        for(Integer key:nodeMap.keySet()){
            if(nodeMap.get(key).inDegree==0)
                q.offer(key);
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
                if(to.inDegree==0)
                    q.offer(child);
            }
        }
        //if has circle, count will be less than graph.length
        return removedEdge == graph.length;
    }
}
