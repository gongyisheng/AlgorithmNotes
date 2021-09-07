package com.orange_yishenggong.algorithm_notes.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Depth {
    //Depth related problems
    public int maxDepth = 0;
    public void clearDepth(){
        maxDepth = 0;
    }

    public void dfs(Node root,int depth){
        if(root==null) return;
        maxDepth = Math.max(maxDepth,depth);
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);

    }
    public void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        maxDepth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            maxDepth++;
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
    }
}
