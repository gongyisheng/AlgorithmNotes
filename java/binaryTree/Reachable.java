package binaryTree;

import binaryTree.util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Orange Meow
 */
public class Reachable {
    /** reachable method one */
    public boolean reachable;
    public void dfsVoidHelper(Node node, int target){
        if(reachable){ return;}
        if(node==null){ return;}
        if(node.val==target){ reachable = true;}
        dfsVoidHelper(node.left,target);
        dfsVoidHelper(node.right,target);
    }
    public boolean dfsVoid(Node node, int target){
        reachable = false;
        dfsVoidHelper(node,target);
        return reachable;
    }
    /** reachable method two */
    public boolean dfsBoolean(Node node,int target){
        if(node==null){ return false;}
        if(node.val==target){ return true;}
        return dfsBoolean(node.left,target)||dfsBoolean(node.right,target);
    }

    public boolean bfs(Node node,int target){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.val==target){
                return true;
            }
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        return false;
    }
}
