package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    FileSystem system;

    @BeforeEach
    void setUp() {
        system = new FileSystem();
    }

    @AfterEach
    void tearDown() {
        system = null;
    }

    @Test
    void systemTest(){
        assertIterableEquals(system.ls("/"),new ArrayList<>());
        system.mkdir("/a/b/c");
        system.addContentToFile("/a/b/c/d","hello");
        assertIterableEquals(system.ls("/"),new ArrayList<>(Arrays.asList("a")));
        assertEquals(system.readContentFromFile("/a/b/c/d"),"hello");
    }
}