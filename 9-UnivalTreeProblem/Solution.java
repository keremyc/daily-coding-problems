

public class Solution {

    public static int solve(BinaryTree.Node root) {

        return univalHelper(root)[0];

    }

    public static int[] univalHelper(BinaryTree.Node node) {

        if (node == null)
            return new int[]{0, 1};
        else {

            int[] left = univalHelper(node.left);
            int[] right = univalHelper(node.right);

            // Initially result is composed of the sum(result[0]) of the number of left and right unival trees
            // and whether left and right subtrees are both unival or not(result[1]).
            int[] result = new int[]{left[0] + right[0], left[1] & right[1]};

            // if both are unival, then some additional requirements are needed to count the enclosing subtree as unival. 
            // root of both subtrees must be equal to the root of enclosing subtree but we ignore null children.
            if (result[1] == 1){
                boolean isUnival = true;

                if (node.left != null) {
                    isUnival = node.left.value == node.value;
                }
                if (node.right != null) {
                    isUnival = isUnival && (node.right.value == node.value);
                }

                result[1] = isUnival ? 1: 0; 
                result[0] = isUnival ? result[0] + 1 : result[0];
            }

            return result;
        }


    }


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node("0");
        tree.root.left = new BinaryTree.Node("0");
        tree.root.right = new BinaryTree.Node("0");
        tree.root.right.left = new BinaryTree.Node("1");
        tree.root.right.right = new BinaryTree.Node("0");
        tree.root.right.left.right = new BinaryTree.Node("1");
        tree.root.right.left.left = new BinaryTree.Node("1");

        System.out.println(solve(tree.root));
        
    }

    public static class BinaryTree {

        public Node root;

        static class Node {
            public String value;
            public Node left;
            public Node right;

            public Node(String value) {
                this.value = value;
            }

        }

    }
}
