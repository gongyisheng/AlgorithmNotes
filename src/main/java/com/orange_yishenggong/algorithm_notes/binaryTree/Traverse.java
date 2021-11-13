package com.orange_yishenggong.algorithm_notes.binaryTree;

import com.orange_yishenggong.algorithm_notes.binaryTree.util.Node;

import java.util.*;
//Time Complexity: O(N)
//Space Complexity: O()

public class Traverse {

    //recursive methods
    public static List<Integer> path = new ArrayList<>();
    public static void clearPath(){
        path.clear();
    }
    public static void preorder_recursive(Node root){
        if(root==null) return;
        path.add(root.val);
        preorder_recursive(root.left);
        preorder_recursive(root.right);
    }
    public static void inorder_recursive(Node root){
        if(root==null) return;
        inorder_recursive(root.left);
        path.add(root.val);
        inorder_recursive(root.right);
    }
    public static void postorder_recursive(Node root){
        if(root==null) return;
        postorder_recursive(root.left);
        postorder_recursive(root.right);
        path.add(root.val);
    }
    //iterative methods
    public static void preorder_iterative(Node root){
        Stack<Node> stack = new Stack<>();
        if(root!=null) stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            path.add(node.val);
            // Remember to reverse order.. right -> left
            // So that when the stack pop nodes, it pop left first then right.
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
    }
    public static void inorder_iterative(Node root){
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            Node node = stack.pop();
            path.add(node.val);
            curr = node.right;
        }
    }
    public static void postorder_iterative(Node root){
            Stack<Node> stack = new Stack<Node>();

            Node curr = root;
            Node prev = null;
            if(root != null) stack.push(root);

            while(!stack.isEmpty()){
                curr = stack.peek();

                // curr 在 prev 下面，要尝试探索所有 curr 下面的节点
                // 如果 curr 是叶节点的话，会在最后把 prev 赋值成 curr，再下一轮的时候被 pop 掉。
                if(prev == null || prev.left == curr || prev.right == curr){
                    if(curr.left != null){
                        stack.push(curr.left);
                    } else if(curr.right != null){
                        stack.push(curr.right);
                    }
                } else if(curr.left == prev){
                    // 刚把左边处理完回来，看看右边还有没有节点
                    if(curr.right != null) stack.push(curr.right);
                } else {
                    // 左右子树都处理完了，处理当前节点。
                    path.add(curr.val);
                    stack.pop();
                }
                prev = curr;
            }
    }
    public static void levelOrder(Node root){
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

    public static void verticalOrder(Node root){
        class Pair{
            Node key;
            int val;
            public Pair(Node node,int value){
                key = node;
                val = value;
            }
        }
        Map<Integer,List<Integer>> orderMap = new HashMap<>();
        int min = 0;
        int max = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            min = Math.min(pair.val,min);
            max = Math.max(pair.val,max);
            orderMap.putIfAbsent(pair.val,new ArrayList());
            orderMap.get(pair.val).add(pair.key.val);
            if(pair.key.left!=null)
                q.offer(new Pair(pair.key.left,pair.val-1));
            if(pair.key.right!=null)
                q.offer(new Pair(pair.key.right,pair.val+1));
        }
        for(int i=min;i<=max;i++){
            for(Integer val:orderMap.get(i)){
                path.add(val);
            }
        }
    }
}
