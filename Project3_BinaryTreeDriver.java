import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        int choice, value;

        // Reading integers from int-input.txt
        readValuesFromFile(tree, "int-input.txt");

        // Main loop to drive the binary tree operations
        do {
            System.out.println("\nBinary Tree Operations Menu:");
            System.out.println("1. Add a node");
            System.out.println("2. Remove a node");
            System.out.println("3. In-order traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add: ");
                    int value = scanner.nextInt();
                    tree.add(value);
                    break;

                case 2:
                    System.out.print("Enter the value to remove: ");
                    value = scanner.nextInt();
                    tree.remove(value);
                    break;

                case 3:
                    System.out.println("In-order traversal of the tree:");
                    tree.inOrderTraversal(tree.root);
                    System.out.println(); // Newline after traversal
                    break;

                case 4:
                    System.out.println("Invalid choice. Please try again.");
                    break;

                default:
                    System.out.println("Invalid choice Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Method to read values from a file and add them to the binary tree
    private static void readValuesFromFile(BinaryTree tree, String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextInt()) { // Assuming the input file contains integers
                int value = fileScanner.nextInt();
                tree.add(value); // Add each value to the tree
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
