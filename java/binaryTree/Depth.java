package binaryTree;

import binaryTree.util.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Orange Meow
 */
public class Depth {
    /** Depth related problems */
    private int maxDepth;
    private int minDepth;

    /** max depth */
    public int calcMaxDepthDfsInt(Node root){
        if(root==null){ return 0;}
        return Math.max(calcMaxDepthDfsInt(root.left),calcMaxDepthDfsInt(root.right))+1;
    }

    public int calcMaxDepthDfsVoid(Node root){
        maxDepth = 0;
        calcMaxDepthDfsVoidHelper(root,1);
        return maxDepth;
    }
    private void calcMaxDepthDfsVoidHelper(Node root,int depth){
        if(root==null){ return;}
        maxDepth = Math.max(maxDepth,depth);
        calcMaxDepthDfsVoidHelper(root.left,depth+1);
        calcMaxDepthDfsVoidHelper(root.right,depth+1);
    }

    public int calcMaxDepthBfs(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        int depth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return depth;
    }

    /** min depth */
    public int calcMinDepthDfsInt(Node root){
        if(root == null){ return 0;}

        if(root.left == null){
            return calcMinDepthDfsInt(root.right) + 1;
        }
        if(root.right == null){
            return calcMinDepthDfsInt(root.left) + 1;
        }

        return Math.min(calcMinDepthDfsInt(root.left), calcMinDepthDfsInt(root.right)) + 1;
    }

    public int calcMinDepthDfsVoid(Node root){
        minDepth = Integer.MAX_VALUE;
        calcMinDepthDfsVoidHelper(root,1);
        return minDepth;
    }
    public void calcMinDepthDfsVoidHelper(Node root,int depth){
        if(root==null){ return;}
        if(root.left==null&&root.right==null){
            minDepth = Math.min(minDepth,depth);
        }
        calcMinDepthDfsVoidHelper(root.left,depth+1);
        calcMinDepthDfsVoidHelper(root.right,depth+1);
    }

    public int calcMinDepthBfs(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        int depth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if(node.left==null&&node.right==null) {
                    return depth;
                }
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return depth;
    }

    /** Balance */
    public static boolean isBalanced(Node root) {
        return helper(root) != -1;
    }

    /**If the height of left and right subtree differ 
     * no more than 1 for every node in the tree, 
     * it is a balanced tree. */
    private static int helper(Node root){
        if(root == null){ return 0;}

        int left = helper(root.left);
        int right = helper(root.right);

        if(left == -1 || right == -1){ return -1;}
        if(Math.abs(left - right) > 1){ return -1;}

        return Math.max(left, right) + 1;
    }
}
