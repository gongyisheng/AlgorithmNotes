package com.orange_yishenggong.algorithm_notes.binaryTree;

import com.orange_yishenggong.algorithm_notes.binaryTree.util.Converter;
import com.orange_yishenggong.algorithm_notes.binaryTree.util.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthTest {
    Depth depth;
    List<String> list;

    @BeforeEach
    void setUp() {
        depth = new Depth();
        list = new ArrayList<>();
        list.add("0,1,3,X,X,4,X,X,2,5,X,X,6,X,X");
        list.add("0,1,3,5,X,X,6,X,X,4,X,X,2,X,X");
        list.add("0,1,3,5,7,X,X,X,6,X,X,4,X,X,2,X,X");
        list.add("0,1,3,5,7,X,X,X,6,X,X,4,X,X,2,X,8,X,9,X,10,X,X");
    }

    @AfterEach
    void tearDown() {
        depth = null;
    }

    @Test
    void depthTest(){
        for(String str:list){
            Node root = Converter.deserialize(str);
            assertEquals(str,Converter.serialize(root));
            assertEquals(depth.calcMaxDepthDfsVoid(root),depth.calcMaxDepthDfsInt(root));
            assertEquals(depth.calcMaxDepthDfsVoid(root),depth.calcMaxDepthBfs(root));
            assertEquals(depth.calcMinDepthDfsVoid(root),depth.calcMinDepthDfsInt(root));
            assertEquals(depth.calcMinDepthDfsVoid(root),depth.calcMinDepthBfs(root));
        }
    }

}
//    Node root = new Node(0);
//        root.left = new Node(1);
//                root.right = new Node(2);
//                root.left.left = new Node(3);
//                root.left.right = new Node(4);
//                root.left.left.left = new Node(5);
//                root.left.left.right = new Node(6);
//                root.left.left.left.left = new Node(7);
//                root.right.right = new Node(8);
//                root.right.right.right = new Node(9);
//                root.right.right.right.right = new Node(10);