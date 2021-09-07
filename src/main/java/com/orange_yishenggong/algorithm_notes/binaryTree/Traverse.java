package com.orange_yishenggong.algorithm_notes.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Traverse {
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
}
