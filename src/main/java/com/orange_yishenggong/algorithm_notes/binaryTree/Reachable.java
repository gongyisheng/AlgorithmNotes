package com.orange_yishenggong.algorithm_notes.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Reachable {

    public boolean reachable = false;
    public void dfs_void(Node node,int target){
        if(reachable) return;
        if(node==null) return;
        if(node.val==target) reachable = true;
        dfs_void(node.left,target);
        dfs_void(node.right,target);
    }

    public boolean dfs_boolean(Node node,int target){
        if(node==null) return false;
        if(node.val==target) return true;
        return dfs_boolean(node.left,target)||dfs_boolean(node.right,target);
    }

    public void dfs(Node node,int target){
        boolean ans1 = dfs_boolean(node,target);
        reachable = false;
        dfs_void(node,target);
        boolean ans2 = reachable;
        System.out.println("The result of dfs_boolean is: "+ans1);
        System.out.println("The result of dfs_void is: "+ans2);
    }

    public boolean bfs(Node node,int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.val==target)
                return true;
            if(curr.left!=null)
                q.offer(curr.left);
            if(curr.right!=null)
                q.offer(curr.right);
        }
        return false;
    }
}
