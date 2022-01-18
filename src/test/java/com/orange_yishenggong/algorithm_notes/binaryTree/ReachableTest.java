package com.orange_yishenggong.algorithm_notes.binaryTree;

import com.orange_yishenggong.algorithm_notes.binaryTree.util.Converter;
import com.orange_yishenggong.algorithm_notes.binaryTree.util.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReachableTest {
    Reachable reachable;
    List<String> list;

    @BeforeEach
    void setUp() {
        reachable = new Reachable();
        list = new ArrayList<>();
        list.add("0,1,3,X,X,4,X,X,2,5,X,X,6,X,X");
        list.add("0,1,3,5,X,X,6,X,X,4,X,X,2,X,X");
        list.add("0,1,3,5,7,X,X,X,6,X,X,4,X,X,2,X,X");
        list.add("0,1,3,5,7,X,X,X,6,X,X,4,X,X,2,X,8,X,9,X,10,X,X");
    }

    @AfterEach
    void tearDown() {
        reachable = null;
    }

    @Test
    void reachableTest() {
        for(String str:list){
            Node root = Converter.deserialize(str);
            assertEquals(reachable.dfsVoid(root,1),true);
            assertEquals(reachable.dfsBoolean(root,1),true);
            assertEquals(reachable.bfs(root,1),true);
            assertEquals(reachable.dfsVoid(root,3),true);
            assertEquals(reachable.dfsBoolean(root,3),true);
            assertEquals(reachable.bfs(root,3),true);
            assertEquals(reachable.dfsVoid(root,20),false);
            assertEquals(reachable.dfsBoolean(root,20),false);
            assertEquals(reachable.bfs(root,20),false);
        }
    }

}