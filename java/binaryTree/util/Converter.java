package binaryTree.util;

/**
 * @author Orange Meow
 */
public class Converter {
    private static final String SPLITER = ",";
    private static final String NULLSTR = "X";
    /** encode */
    public static String serialize(Node node){
        if(node==null) {
            return NULLSTR;
        }
        StringBuilder path = new StringBuilder();
        path.append(node.val);
        path.append(SPLITER);
        path.append(serialize(node.left));
        path.append(SPLITER);
        path.append(serialize(node.right));
        return path.toString();
    }
    /** decode */
    private static int p;
    private static Node deserializeHelper(String[] list){
        if(p>= list.length){
            return null;
        }
        if(list[p].equals(NULLSTR)) {
            p++;
            return null;
        }
        Node curr = new Node(Integer.parseInt(list[p]));
        p++;

        curr.left = deserializeHelper(list);
        curr.right = deserializeHelper(list);
        return curr;
    }
    public static Node deserialize(String data) {
        p = 0;
        String[] list = data.split(SPLITER);
        return deserializeHelper(list);
    }
}
