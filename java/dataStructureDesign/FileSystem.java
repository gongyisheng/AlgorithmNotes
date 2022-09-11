package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A data structure that simulates an in-memory file system.
 *
 * Complexity Analysis:
 * Time Complexity: O(N) for ls, O(logN) for mkdir,addContent, O(D) for readContent
 * Space Complexity: O(N) to support the whole system.
 *
 * Thoughts:
 * 1. Parent-children structure: HashMap
 * 2. In lexicographic order: A container with comparator
 * 3. Add content frequently: StringBuilder
 */
class FileSystem {
    private class Node {
        public boolean isFile;
        public String name;
        public Map<String,Node> children;
        public StringBuilder content;
        public Node(String name,boolean isFile){
            this.isFile = isFile;
            this.name = name;
            if(isFile){
                this.content = new StringBuilder();
            }else{
                this.children = new TreeMap<String,Node>();
            }
        }
    }

    private final Node root;

    public FileSystem() {
        this.root = new Node("root",false);
    }

    private Node getNodeByPath(String[] path_list,int end){
        Node curr = this.root;
        for(int i=1;i<Math.min(path_list.length,end);i++){
            if(curr.children.containsKey(path_list[i])){
                curr = curr.children.get(path_list[i]);
            }else{
                return null;
            }
        }
        return curr;
    }
    private Node getAndCreateNodeByPath(String[] path_list,int end){
        Node curr = this.root;
        for(int i=1;i<Math.min(path_list.length,end);i++){
            curr.children.putIfAbsent(path_list[i],new Node(path_list[i],false));
            curr = curr.children.get(path_list[i]);
        }
        return curr;
    }

    /**
     * Return the file name of a file / directory and file names in the directory
     *   If path is a file path, returns a list that only contains this file's name.
     *   If path is a directory path, returns the list of file and directory names in this directory.
     * The answer should in lexicographic order.
     * @param path A string indicates the path of the directory/file
     * @return A list with file & directory names in lexicographic order.
     */
    public List<String> ls(String path) {
        List<String> list = new ArrayList<>();
        String[] path_list = path.split("/");
        Node curr = getNodeByPath(path_list,Integer.MAX_VALUE);
        if(curr!=null){
            if(curr.isFile){
                list.add(curr.name);
            }else{
                list.addAll(curr.children.keySet());
            }
        }
        return list;
    }

    /**
     * Makes a new directory according to the given path.
     * The given directory path does not exist.
     * If the middle directories in the path do not exist, the method will create them as well.
     *
     * @param path A string indicates the path of the directory
     */
    public void mkdir(String path) {
        String[] path_list = path.split("/");
        getAndCreateNodeByPath(path_list,Integer.MAX_VALUE);
    }

    /**
     * Append content to a file according to filePath
     *   If filePath does not exist, creates that file containing given content.
     *   If filePath already exists, appends the given content to original content.
     * @param filePath A string indicates the path of the file.
     * @param content A string indicates the additional content to be appended to the file.
     */
    public void addContentToFile(String filePath, String content) {
        String[] path_list = filePath.split("/");
        Node curr = getAndCreateNodeByPath(path_list,path_list.length-1);
        curr.children.putIfAbsent(path_list[path_list.length-1],new Node(path_list[path_list.length-1],true));
        curr = curr.children.get(path_list[path_list.length-1]);
        curr.content.append(content);
    }

    /**
     * Returns the content in the file at filePath.
     *   If the path does not exist, return empty string.
     * @param filePath A string indicates the path of the file.
     * @return The content of the file.
     */
    public String readContentFromFile(String filePath) {
        String[] path_list = filePath.split("/");
        Node curr = getNodeByPath(path_list,Integer.MAX_VALUE);
        return curr==null? "":curr.content.toString();
    }
}
