package com.orange_yishenggong.algorithm_notes.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Depth {
    //Depth related problems
    public int maxDepth = Integer.MIN_VALUE;
    public int minDepth = Integer.MAX_VALUE;
    public void clearDepth(){
        maxDepth = Integer.MIN_VALUE;
        minDepth = Integer.MAX_VALUE;
    }

    //max depth
    public int calcMaxDepth_DFS_int(Node root){
        if(root==null) return 0;
        return Math.max(calcMaxDepth_DFS_int(root.left),calcMaxDepth_DFS_int(root.right))+1;
    }

    public void calcMaxDepth_DFS_void(Node root,int depth){
        if(root==null) return;
        maxDepth = Math.max(maxDepth,depth);
        calcMaxDepth_DFS_void(root.left,depth+1);
        calcMaxDepth_DFS_void(root.right,depth+1);
    }

    public void calcMaxDepth_BFS(Node root){
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
    
    //min depth
    public int calcMinDepth_DFS_int(Node root){
        if(root == null) return 0;

        if(root.left == null) return calcMinDepth_DFS_int(root.right) + 1;
        if(root.right == null) return calcMinDepth_DFS_int(root.left) + 1;

        return Math.min(calcMinDepth_DFS_int(root.left), calcMinDepth_DFS_int(root.right)) + 1;
    }

    public void calcMinDepth_DFS_void(Node root,int depth){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            minDepth = Math.min(minDepth,depth);
        }
        calcMinDepth_DFS_void(root.left,depth+1);
        calcMinDepth_DFS_void(root.right,depth+1);
    }

    public void calcMinDepth_BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if(node.left==null&&node.right==null) {
                    minDepth = depth;
                    return;
                }
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
    }
}
