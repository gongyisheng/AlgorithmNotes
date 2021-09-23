package com.orange_yishenggong.algorithm_notes.binaryTree;

import java.util.Stack;
//                   Binary Tree   ||    BST
//Time Complexity:       O(n)          O(logN)
//Space Complexity:      O(n)            O(1)

public class Successor {
    public static int preorder_successor(Node root,int val){
        if(root==null) return -1;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node prev = null;
        Node curr = root;

        while(!stack.isEmpty()){
            curr = stack.pop();
            if(prev!=null&&prev.val==val)
                return curr.val;
            prev = curr;

            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);
        }
        return -1;
    }

    public static int inorder_successor(Node root,int val){
        if(root==null) return -1;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Node prev = null;
        stack.push(root);

        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev!=null&&prev.val==val)
                return curr.val;
            prev = curr;
            curr = curr.right;
        }
        return -1;
    }

    public static int postorder_successor(Node root,int val){
        if(root==null) return -1;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Node prev = null;
        Node prevOutput = null;
        stack.push(root);

        while(!stack.isEmpty()){
            curr = stack.peek();

            if(prev==null||prev.left==curr||prev.right==curr){
                if(curr.left!=null)
                    stack.push(curr.left);
                else if(curr.right!=null)
                    stack.push(curr.right);
            }
            else if(curr.left == prev){
                if(curr.right!=null)
                    stack.push(curr.right);
            }
            else{
                if(prevOutput!=null&&prevOutput.val==val){
                    return curr.val;
                }
                prevOutput = stack.pop();
            }
            prev = curr;
        }
        return -1;
    }

    public static int inorder_successor_BST(Node root,int val){
        Node rst = null;
        Node curr = root;
        while(curr!=null){
            //to find the node, when curr.val is smaller than target value, we should go left
            //when we already find the node and goes to the right subtree of the node, we should continuously go left to find out its successor
            if(curr.val>val){
                rst = curr;
                curr = curr.left;
            }
            //to find the node, when curr.val is smaller than target value, we should go right
            //when we find the node and curr.val is equal to target value, we also should go right to find its successor.
            else
                curr = curr.right;
        }
        return rst==null? -1:rst.val;
    }
}
