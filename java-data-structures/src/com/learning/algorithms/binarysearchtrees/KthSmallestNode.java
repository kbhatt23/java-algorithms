package com.learning.algorithms.binarysearchtrees;

public class KthSmallestNode {
public static void main(String[] args) {
	BinarySearchTree<Integer> tree = new BinarySearchTree<>();
	tree.add(23);
	tree.add(24);
	tree.add(20);
	tree.remove(20);
	System.out.println(tree.findSmallest(22));
	System.out.println(tree.size());
}
}
