package BST;

public class StructuralTree {
    static class Node {
        int data;
        Node left;
        Node right;
    };

    // Utility function to create a new Node
    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return node;
    }

    // Function to perform inorder traversal
    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    // Function to check if two BSTs
    // are identical
    static int isIdentical(Node root1,
            Node root2) {
        // Check if both the trees are empty
        if (root1 == null && root2 == null)
            return 1;

        // If any one of the tree is non-empty
        // and other is empty, return false
        else if (root1 != null &&
                root2 == null)
            return 0;
        else if (root1 == null &&
                root2 != null)
            return 0;
        else {
            // Check if current data of both trees equal
            // and recursively check for left and right subtrees
            if (root1.data == root2.data &&
                    isIdentical(root1.left, root2.left) == 1 &&
                    isIdentical(root1.right, root2.right) == 1)
                return 1;
            else
                return 0;
        }
    }

    // Driver code
    public static void main(String[] args) {
        Node root1 = newNode(5);
        Node root2 = newNode(5);
        root1.left = newNode(3);
        root1.right = newNode(8);
        root1.left.left = newNode(2);
        root1.left.right = newNode(4);

        root2.left = newNode(3);
        root2.right = newNode(8);
        root2.left.left = newNode(2);
        root2.left.right = newNode(4);

        if (isIdentical(root1, root2) == 1)
            System.out.print("Both BSTs are identical");
        else
            System.out.print("BSTs are not identical");
    }
}
