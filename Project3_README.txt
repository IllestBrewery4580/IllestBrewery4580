# Binary Search Tree Implementation

## Overview
This project demonstrates the implementation of a **Binary Search Tree (BST)** in Java. It allows for insertion, deletion, and in-order traversal of integer values. The BST is structured into three classes, each fulfilling a key role in the tree's functionality.

## Project Structure

1. **NodeType.java**
    This class represents the structure of a single node in the binary search tree. Each node contains:
    - An integer 'data' value.
    - A reference to the left child node ('left').
    - A reference to the right child node ('right').
    This class provides methods for getting and setting node values and references.

2. **BinarySearchTree.java**
   This class implements the core functionality of the binary search tree. It allows:
   - Insertion of a new node into the tree.
   - Deletion of an existing node.
   - In-order traversal of the tree to display elements in sorted order.

3. **Main.java**
   The entry point of the program, containing the 'main' method. This class:
   - Instantiates the binary search tree.
   - Adds and removes elements.
   - Displays the output of the in-order traversal.

## How to Run

1. Ensure that all three ".java" files are in the same directory.
2. Compile the files using the following command in the terminal.


## Features
- **Insertion**: Adds a new integer node to the BST.
- **Deletion**: Removes a specific node while maintaining the bST properties.
- **In-Order Traversal**: Prints all elements of the tree in ascending order.
