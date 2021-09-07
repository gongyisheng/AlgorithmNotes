package com.orange_yishenggong.algorithm_notes.binaryTree;

import java.util.*;
//Time Complexity: O(N)
//Space Complexity: O()

public class Traverse {

    //traverse related problems
    public List<Integer> path = new ArrayList<>();
    public void clearPath(){
        path.clear();
    }
    public void preorder(Node root){
        if(root==null) return;
        path.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(Node root){
        if(root==null) return;
        path.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }
    public void postorder(Node root){
        if(root==null) return;
        path.add(root.val);
        postorder(root.left);
        postorder(root.right);
    }
    public void levelorder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node node = q.poll();
                path.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
    }
}
