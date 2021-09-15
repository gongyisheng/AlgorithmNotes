package com.orange_yishenggong.algorithm_notes.binaryTree;

public class Converter {
    //encode
    private static String serialize(Node node){
        StringBuilder path = new StringBuilder();
        if(node==null) {
            path.append("null");
            return path.toString();
        }
        path.append(node.val);
        path.append(",");
        path.append(serialize(node.left));
        path.append(",");
        path.append(serialize(node.right));
        return path.toString();
    }
    //decode
    private static int p = 0;
    private static Node dfs_deserialize(String[] list){
        if(p>= list.length) return null;
        if(list[p].equals("null")) {
            p++;
            return null;
        }
        Node curr = new Node(Integer.valueOf(list[p]));
        p++;

        curr.left = dfs_deserialize(list);
        curr.right = dfs_deserialize(list);
        return curr;
    }
    public static Node deserialize(String data) {
        String[] data_list = data.split(",");
        return dfs_deserialize(data_list);
    }
}
