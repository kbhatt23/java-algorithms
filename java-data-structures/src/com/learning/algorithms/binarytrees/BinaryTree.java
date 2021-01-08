package com.learning.algorithms.binarytrees;

import java.util.List;

import com.learning.algorithms.queues.QueueList;

public class BinaryTree<T> {

	private BinaryTreeNode<T> root;
	
	public void add(T element) {
		BinaryTreeNode<T> newNode = new BinaryTreeNode<>(element,null,null);
		if(root == null) {
			root=newNode;
		}else {
			//atleast one element exist
			QueueList<BinaryTreeNode<T>> queue = new QueueList<>();
			queue.enqueue(root);
			while(!queue.isEmpty()) {
				BinaryTreeNode<T> currentNode = queue.peek();
				if(currentNode.getLeft() == null) {
					currentNode.setLeft(newNode);
					break;
				}
				if(currentNode.getRight() == null) {
					currentNode.setRight(newNode);
					break;
				}
				queue.enqueue(currentNode.getLeft());
				queue.enqueue(currentNode.getRight());
				queue.dequeue();
			}
			
		}
	}
	
	public void printLevelOrder() {
		if(root==null)
			throw new IllegalStateException("Can not traverse empty Tree");
		QueueList<BinaryTreeNode<T>> queue = new QueueList<>();
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> currentNode = queue.peek();
			System.out.println("printLevelOrder:Found tree node "+currentNode.getValue());
			if(currentNode.getLeft() != null) {
				queue.enqueue(currentNode.getLeft());
			}
			if(currentNode.getRight() != null) {
				queue.enqueue(currentNode.getRight());
			}
			queue.dequeue();
		}
	}
	
	public void printPreOrder() {
		if(root==null)
			throw new IllegalStateException("Can not traverse empty Tree");
		
		printPreOrderRecursively(root);
		
	}

	private void printPreOrderRecursively(BinaryTreeNode<T> node) {
		if(node == null)
			return;
		System.out.println("printPreOrder: Found tree node "+node.getValue());
		printPreOrderRecursively(node.getLeft());
		printPreOrderRecursively(node.getRight());
	}
	
	public void printPostOrder() {
		if(root==null)
			throw new IllegalStateException("Can not traverse empty Tree");
		
		printPostOrderRecursively(root);
		
	}

	private void printPostOrderRecursively(BinaryTreeNode<T> node) {
		if(node == null)
			return;
		printPostOrderRecursively(node.getLeft());
		printPostOrderRecursively(node.getRight());
		System.out.println("printPostOrder: Found tree node "+node.getValue());
	}
	
	public void printInOrder() {
		if(root==null)
			throw new IllegalStateException("Can not traverse empty Tree");
		
		printInOrderRecursively(root);
		
	}

	private void printInOrderRecursively(BinaryTreeNode<T> node) {
		if(node == null)
			return;
		printInOrderRecursively(node.getLeft());
		System.out.println("printPreOrder: Found tree node "+node.getValue());
		printInOrderRecursively(node.getRight());
	}
	
}
