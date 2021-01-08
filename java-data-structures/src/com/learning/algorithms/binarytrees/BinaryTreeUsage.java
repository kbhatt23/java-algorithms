package com.learning.algorithms.binarytrees;

public class BinaryTreeUsage {
	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		binaryTree.add(10);
		binaryTree.add(15);
		binaryTree.add(16);
		binaryTree.add(20);
		binaryTree.add(24);
		
		binaryTree.printLevelOrder();
		System.out.println("=======");
		binaryTree.printPreOrder();
		
		System.out.println("=======");
		binaryTree.printPostOrder();
		
		System.out.println("=======");
		binaryTree.printInOrder();
		
		
	}
}
