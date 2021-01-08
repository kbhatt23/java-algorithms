package com.learning.algorithms.binarysearchtrees;

public class BinarySearchTreeEqualsChallenge {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree= new BinarySearchTree<>();
		tree.add(23);
		tree.add(16);
		
		tree.add(14);
		tree.add(28);
		tree.add(5);
		
		tree.add(24);
		
		
		BinarySearchTree<Integer> tree2= new BinarySearchTree<>();
		tree2.add(23);
		tree2.add(16);
		
		tree2.add(14);
		tree2.add(28);
		tree2.add(5);
		
		tree2.add(24);
		
		System.out.println(tree.equals(tree2));
	}
}
