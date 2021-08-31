package com.orange_yishenggong.algorithm_notes.graph;

import java.util.ArrayList;
import java.util.List;

class UF {
    public int[] sz;
    public int[] id;
    public UF(int size){
        this.sz = new int[size+1];
        this.id = new int[size+1];
        for(int i=0;i<=size;i++){
            sz[i] = 1;
            id[i] = i;
        }
    }
    //find the root of element
    public int find(int p){
        int root = p;
        while(id[root]!=root){
            root = id[root];
        }

        //path compression
        while(p!=root){
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public boolean union(int p1,int p2){
        int root1 = find(p1);
        int root2 = find(p2);
        if(root1==root2) return false;

        //union by the element number of tree
        if(sz[root1]>sz[root2]){
            id[root2] = root1;
            sz[root1] += sz[root2];
        } else {
            id[root1] = root2;
            sz[root2] += sz[root1];
        }
        return true;
    }
}
public class UnionFind {
    public static List<Integer> toList(int[] intList){
        List<Integer> ans = new ArrayList<>();
        for(int i:intList)
            ans.add(i);
        return ans;
    }
    public static List<Integer> findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1]))
                return toList(edge);
        }
        return toList(new int[0]);
    }
}