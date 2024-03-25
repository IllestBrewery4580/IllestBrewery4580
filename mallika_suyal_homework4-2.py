# -*- coding: utf-8 -*-
"""Mallika_Suyal_Homework4

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1lNLd-gbdkcmKU4WKACapUPgkoTZ8ufJB
"""

#Task 1: Linked List
class Node:
  def __init__(self, data=None):
    self.data = data
    self.nxt = None

class CircularLinkedList:
  def __init__(self):
    self.head = None

  def append(self, data):
    new_node = Node(data)
    if not self.head:
      self.head = new_node
      self.head.nxt = self.head
    else:
      current = self.head
      while current.nxt != self.head:
        current = current.nxt
      current.nxt = new_node
      new_node.nxt = self.head

  def remove(self, node):
    current = self.head
    prev = None
    while current.data != node:
      prev = current
      current = current.nxt
    if current == self.head:
      while current.nxt != self.head:
        current = current.nxt
      current.nxt = self.head.nxt
      self.head = self.head.nxt
    else:
      prev.nxt = current.nxt


def simulate_potato_game(n, k):
  people = CircularLinkedList()
  for i in range(n):
    people.append(i)

  current_person = people.head
  while people.head.nxt != people.head:
    for step in range(k - 1):
    #Step used to be _ but I didn't like it at all. It felt like I just dodn't know what variable to put
      current_person = current_person.nxt
    next_person = current_person.nxt.data
    people.remove(next_person)
    if current_person == people.head:
      people.head = people.head.nxt
    current_person = current_person.nxt

  return people.head.data


#Test the function
n = int(input("Enter the number of people in your group: "))
k = int(input("Enter number of steps in one iteration of the rhyme: "))
print("Last remaining person's number:", simulate_potato_game(n, k))





#Task 2: Linked List
class TreeNode:
  def __init__(self, value, left, right):
    self.value = value
    self.left = left
    self.right = right

def height(node):
  if node is None:
    return -1
  return 1 + max(height(node.left), height(node.right))

def count_leaves(node):
  if node is None:
    return 0
  if node.left is None and node.right is None:
    return 1
  return count_leaves(node.left) + count_leaves(node.right)

def is_full(node):
  if node is None:
    return True
  if node.left is None and node.right is None:
    return True
  if node.left is not None and node.right is not None:
    return is_full(node.left) and is_full(node.right)
  return False

def is_balanced(node):
  if node is None:
    return True
  lh = height(node.left)
  rh = height(node.right)
  if abs(lh - rh) <= 1 and is_balanced(node.left) and is_balanced(node.right):
    return True
  return False

def tree_info(node):
  h = height(node)
  leaves = count_leaves(node)
  full = "Yes" if is_full(node) else "No"
  balanced = "Yes" if is_balanced(node) else "No"

  print("Height of the tree:", h) #height of tree is printing wrong.
  #Correct output: 2, Your Output: 3
  print("Number of leaf nodes:", leaves)
  print("Is Full:", full)
  print("Is Balanced:", balanced)


leaf1 = TreeNode(4, None, None)
leaf2 = TreeNode(5, None, None)
leaf3 = TreeNode(8, None, None)

# Intermediate nodes
intermediate1 = TreeNode(9, leaf1, leaf2)
root = TreeNode(3, intermediate1, leaf3)

# Call the tree_info function
tree_info(root)