import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinaryTree {
    NodeType root;


    // Constructor to initialize the tree with no root node
    public BinaryTree() {
        root = null;
    }

    // Method to add a new node to the binary tree
    public void add(int value) {
        root = addRecursive(root, value);
    }

    // Recursive helper method to add a new value to the tree
    private NodeType addRecursive(NodeType node, int value) {
        if (node == null) {
            return new NodeType(value); // Create a new node if the current node is null
        }

        if (value  < node.data) {
            node.left = addRecursive(node.left, value);
        } else if (value > node.data) {
            node.right = addRecursive(node.right, value);
        }

        return node; // Return the (unchanged) node pointer
    }

    // Method to remove a node from the binary tree
    public void remove(int value) {
        root = removeRecursive(root, value);
    }

    // Recursive helper method to remove a value from the tree
    private NodeType removeRecursive(NodeType node, int value) {
        if (node == null) {
            return null; // Base case: if the tree is empty
        }

        if (value < node.data) {
            node.left = removeRecursive(node.left, value);
        } else if (value > node.data) {
            node.right = removeRecursive(node.right, value);
        } else {
            // Node found: handle the three cases

            // Case 1: Node has no children (leaf node)
            if (node.left == null && node.right == null) {
                return null;
            } // This line was misplaced outside the if block

            // Case 2: Node has one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 3: Node has two children, find in-order successor (smallest node in right subtree)
            NodeType inOrderSuccessor = findMin(node.right);
            node.data = inOrderSuccessor.data;
            node.right = removeRecursive(node.right, inOrderSuccessor.data); // Remove the successor
        }

        return node;
    }

    // Helper method to find the minimum value node
    private NodeType findMin(NodeType node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // In-order traversal (left-root-right) to display nodes in sorted order
    public void inOrderTraversal(NodeType node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
}
