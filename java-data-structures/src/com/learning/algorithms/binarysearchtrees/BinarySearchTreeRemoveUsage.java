package com.learning.algorithms.binarysearchtrees;

public class BinarySearchTreeRemoveUsage {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree= new BinarySearchTree<>();
		tree.add(23);
		tree.add(16);
		
		tree.add(14);
		tree.add(28);
		tree.add(5);
		tree.add(3);
		tree.add(17);
		tree.add(9);
		tree.add(32);
		
		tree.add(24);
		//tree.add(29);
		System.out.println("smallest val "+tree.smallestValue());
		System.out.println("highest val "+tree.highestValue());
		tree.remove(28);
		
		//tree.printLevelOrder();
		tree.printInOrder();
		
		System.out.println("=========================");
		tree.printLevelOrder();
	}
}
