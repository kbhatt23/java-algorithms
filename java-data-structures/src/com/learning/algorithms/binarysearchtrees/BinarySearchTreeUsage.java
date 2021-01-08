package com.learning.algorithms.binarysearchtrees;

public class BinarySearchTreeUsage {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree= new BinarySearchTree<>();
		tree.add(23);
		tree.add(14);
		tree.add(16);
		tree.add(28);
		tree.add(5);
		tree.add(17);
		tree.add(9);
		tree.add(32);
		//tree.printLevelOrder();
		tree.printPreOrder();
		//tree.printPostOrder();
	//	tree.printInOrder();
	}
}
