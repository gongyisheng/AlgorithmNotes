package com.orange_yishenggong.algorithm_notes.binaryTree;

//                     BST       Binary Tree
//Time Complexity:    O(logN)       O(N)
//Space Complexity:    O(1)         O(1)

import java.util.*;

public class LeastCommonAncestor {
    //Since BST has its special structure.Position of numbers and nodes follow rules of BST.
    //We can make full use of this structure and information given by the structure. Avoid make useless searches.
    //We can make decisions based on the info of node itself.
    //Thus, we use preorder recursion.
    public static Node findInBST_recursive(Node root, int p, int q) {
        if(root==null) return null;
        if(root.val>p&&root.val>q)
            return findInBST_recursive(root.left,p,q);
        if(root.val<p&&root.val<q)
            return findInBST_recursive(root.right,p,q);
        return root;
    }

    //Cause it's tail recursion, we use while loop and there's no need for stack.
    public Node findInBST_iterative(Node root,int p,int q){
        while(root!=null){
            if(root.val>p&&root.val>q)
                root = root.left;
            else if(root.val<p&&root.val<q)
                root = root.right;
            else
                return root;
        }
        return root;
    }

    //Since binary trees do not contain any special structures and information.
    //We have to make all possible searches.
    //We cannot make decisions based on the node's info itself, but also the left and right side of node
    //Thus, we use post-order recursion.
    public Node findInBinaryTree_recursive(Node root, int p, int q) {
        if(root==null||root.val==p||root.val==q) return root;

        Node left = findInBinaryTree_recursive(root.left,p,q);
        Node right = findInBinaryTree_recursive(root.right,p,q);

        if(left!=null&&right!=null) return root;
        return left==null? right:left;
    }

    public Node findInBinaryTree_iterative(Node root,Node p,Node q){
        //stack for traversal
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        //hashmap for parent pointers
        Map<Node,Node> parent = new HashMap<>();
        parent.put(root,null);

        while(!parent.containsKey(p)||!parent.containsKey(q)){
            Node node = stack.pop();
            if(node.left!=null){
                stack.push(node.left);
                parent.put(node.left,node);
            }
            if(node.right!=null){
                stack.push(node.right);
                parent.put(node.right,node);
            }
        }
        Set<Node> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }

        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}
