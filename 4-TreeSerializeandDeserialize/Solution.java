import java.util.Stack;

public class Solution {

    public static class Tree {
        public String value;
        public Tree left;
        public Tree right;
    
        public Tree() {
            this("", null, null);
        }
    
        public Tree(String value) {
            this(value, null, null);
        }
    
        public Tree(String value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static String serialize(Tree tree) {

        StringBuilder result = new StringBuilder();

        result.append(tree.value);
        
        if (tree.left != null) {
            result.append("[");
            result.append(serialize(tree.left));
            result.append("]");
        }

        if (tree.right != null) {
            result.append("[");
            result.append(serialize(tree.right));
            result.append("]");
        }

        return result.toString();
    }
    public static Tree deserialize(String str) {

        int rootIndex, seperatorIndex;
        Tree root = new Tree();
        Stack<Character> bracketsPool = new Stack<>();

        rootIndex = str.indexOf("[");
        if(rootIndex == -1) {
            root.value = str;
            return root;
        }
        root.value = str.substring(0, rootIndex);

        seperatorIndex = rootIndex + 1;
        bracketsPool.push('[');
        while(!bracketsPool.empty()) {
            if(str.charAt(seperatorIndex) == '[') {
                bracketsPool.push('[');
            }
            else if(str.charAt(seperatorIndex) == ']') {
                bracketsPool.pop();
            }
            seperatorIndex++;   
        }
        
        root.left = deserialize(str.substring(rootIndex+1, seperatorIndex-1));
        root.right = deserialize(str.substring(seperatorIndex+1, str.length()-1));

        return root;

    }
    public static void main(String[] args) {
        Tree node = new Tree("root", new Tree("left", new Tree("left.left"), new Tree()), new Tree("right"));
        
        System.out.println(deserialize(serialize(node)).value);
        System.out.println(deserialize(serialize(node)).left.value);
        System.out.println(deserialize(serialize(node)).right.value);
        System.out.println(deserialize(serialize(node)).left.left.value);
        
    }

}