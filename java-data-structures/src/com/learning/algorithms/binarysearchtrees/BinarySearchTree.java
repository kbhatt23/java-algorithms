package com.learning.algorithms.binarysearchtrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.learning.algorithms.binarytrees.BinaryTree;
import com.learning.algorithms.binarytrees.BinaryTreeNode;
import com.learning.algorithms.binarytrees.BinaryTreeNode.RelationType;
import com.learning.algorithms.queues.QueueList;
import com.learning.algorithms.stacks.StackList;

public class BinarySearchTree<T extends Comparable<T>> {

	private BinaryTreeNode<T> root;
	private int size;
	//always initialze to 0 before use
	private int nodeSize;

	public void add(T value) {
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value, null, null);
		if (isEmpty())
			root = newNode;
		else {
			BinaryTreeNode<T> node = root;
			while (node != null) {
				if (node.getValue().compareTo(value) > 0) {
					// insert on left
					if (node.getLeft() == null) {
						node.setLeft(newNode);
						break;
					}
					node = node.getLeft();
				} else if (node.getValue().compareTo(value) < 0) {
					// insert on right
					if (node.getRight() == null) {
						node.setRight(newNode);
						break;
					}
					node = node.getRight();
				} else {
					System.out.println("Ignoring Duplicate element " + value);
				}
			}
		}
	}

	public void remove(T value) {
		if (isEmpty())
			throw new IllegalStateException("Can not traverse empty Tree");

		List<BinaryTreeNode<T>> findCurrentAndParent = findCurrentAndParent(value);
		BinaryTreeNode<T> nodeFound = findCurrentAndParent.get(0);
		BinaryTreeNode<T> parentNodeFound = findCurrentAndParent.get(1);
		// when node to remove is leaf
		if (isNodeLeaf(nodeFound)) {
			removeLeafNode(nodeFound, parentNodeFound);
		}
		// when node to remove have both the child
		else if (isBothChildPresent(nodeFound)) {
			removeCompleNode(nodeFound, parentNodeFound);
		}
		// when node to remove has only one child
		else {
			removeSingleChildNode(nodeFound, parentNodeFound);
		}
	}

	private void removeCompleNode(BinaryTreeNode<T> nodeFound, BinaryTreeNode<T> parentNodeFound) {
		if (root.getValue().compareTo(nodeFound.getValue()) == 0) {
			handleLeftChildReomoval(nodeFound);
		} else {
			RelationType childParentNodeRelation = childParentNodeRelation(nodeFound, parentNodeFound);
			if (childParentNodeRelation == RelationType.LARGER) {
				handleRightChildRemoval(nodeFound);

			} else if (childParentNodeRelation == RelationType.SMALLER) {
				handleLeftChildReomoval(nodeFound);
			} else {
				throw new IllegalStateException("Can not have duplicates in tree");
			}
		}
	}

	private void handleRightChildRemoval(BinaryTreeNode<T> nodeFound) {
		// find smallest of subaray
		List<BinaryTreeNode<T>> lowestNodesInSubNode = lowestNodeInSubNode(nodeFound.getRight());
		BinaryTreeNode<T> lowestNodeParent = lowestNodesInSubNode.get(1);
		BinaryTreeNode<T> lowestNode = lowestNodesInSubNode.get(0);
		if (lowestNodeParent != null)
			lowestNodeParent.setLeft(lowestNode.getRight());
		else 
			nodeFound.setRight(lowestNode.getRight());
		nodeFound.setValue(lowestNode.getValue());
	}

	private void handleLeftChildReomoval(BinaryTreeNode<T> nodeFound) {
		// find max of subaray
		List<BinaryTreeNode<T>> highestNodesInSubNode = highestNodeInSubNode(nodeFound.getLeft());
		BinaryTreeNode<T> highestNodeParent = highestNodesInSubNode.get(1);
		BinaryTreeNode<T> highestNode = highestNodesInSubNode.get(0);
		if (highestNodeParent != null)
			highestNodeParent.setRight(highestNode.getLeft());
		else 
			nodeFound.setLeft(highestNode.getLeft());
		nodeFound.setValue(highestNode.getValue());
	}

	private void removeSingleChildNode(BinaryTreeNode<T> nodeFound, BinaryTreeNode<T> parentNodeFound) {
		BinaryTreeNode<T> newChild = nodeFound.getLeft() != null ? nodeFound.getLeft() : nodeFound.getRight();
		if (root.getValue().compareTo(nodeFound.getValue()) == 0) {
			root = newChild;
		} else {
			// case when only one child exists
			RelationType childParentNodeRelation = childParentNodeRelation(nodeFound, parentNodeFound);
			if (childParentNodeRelation == RelationType.LARGER)
				parentNodeFound.setRight(newChild);
			else if (childParentNodeRelation == RelationType.SMALLER)
				parentNodeFound.setLeft(newChild);
			else
				throw new IllegalStateException("Can not have duplicates in tree");
		}
	}

	private void removeLeafNode(BinaryTreeNode<T> nodeFound, BinaryTreeNode<T> parentNodeFound) {
		if (root.getValue().compareTo(nodeFound.getValue()) == 0) {
			// root is leaf, hence removing root will remove tree as there are no child
			removeTree();
		} else {
			// if node do not have any child
			// just clean up
			RelationType childParentNodeRelation = childParentNodeRelation(nodeFound, parentNodeFound);
			if (childParentNodeRelation == RelationType.LARGER)
				parentNodeFound.setRight(null);
			else if (childParentNodeRelation == RelationType.SMALLER)
				parentNodeFound.setLeft(null);
			else
				throw new IllegalStateException("Can not have duplicates in tree");
		}
	}

	private List<BinaryTreeNode<T>> highestNodeInSubNode(BinaryTreeNode<T> node) {
		if (node == null)
			throw new IllegalStateException("Can not iterate empty node");

		BinaryTreeNode<T> parent = null;
		BinaryTreeNode<T> highest = node;
		// in case of no childs of the passed node we return the same node as the
		// higehst
		while (highest.getRight() != null) {
			parent = highest;
			highest = highest.getRight();
		}
		return Arrays.asList(highest, parent);
	}

	private List<BinaryTreeNode<T>> lowestNodeInSubNode(BinaryTreeNode<T> node) {
		if (node == null)
			throw new IllegalStateException("Can not iterate empty node");

		BinaryTreeNode<T> parent = null;
		BinaryTreeNode<T> lowest = node;
		// in case of no childs of the passed node we return the same node as the
		// higehst
		while (lowest.getLeft() != null) {
			parent = lowest;
			lowest = lowest.getLeft();
		}
		return Arrays.asList(lowest, parent);
	}
	
	public T smallestValue() {
		if (root == null)
			throw new IllegalStateException("Can not iterate empty node");
		return lowestNodeInSubNode(root).get(0).getValue();
	}
	
	public T highestValue() {
		if (root == null)
			throw new IllegalStateException("Can not iterate empty node");
		return highestNodeInSubNode(root).get(0).getValue();
	}

	private void removeTree() {
		root = null;
	}

	private boolean isNodeLeaf(BinaryTreeNode<T> node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	private boolean isBothChildPresent(BinaryTreeNode<T> node) {
		return node.getLeft() != null && node.getRight() != null;
	}

	// if child is greate than parent -> right, else left
	private BinaryTreeNode.RelationType childParentNodeRelation(BinaryTreeNode<T> child, BinaryTreeNode<T> parent) {
		if (child.getValue().compareTo(parent.getValue()) > 0) {
			return BinaryTreeNode.RelationType.LARGER;
		} else {
			return BinaryTreeNode.RelationType.SMALLER;
		}
	}

	private List<BinaryTreeNode<T>> findCurrentAndParent(T value) {
		if (isEmpty())
			throw new IllegalStateException("Can not traverse empty Tree");
		BinaryTreeNode<T> parent = null;
		BinaryTreeNode<T> current = root;
		boolean itemFound = false;
		while (current != null) {
			if (current.getValue().compareTo(value) == 0) {
				itemFound = true;
				break;
			}

			if (current.getValue().compareTo(value) > 0) {
				// search in left sub tree
				parent = current;
				current = current.getLeft();
			} else if (current.getValue().compareTo(value) < 0) {
				// search in right sub tree
				parent = current;
				current = current.getRight();
			}
		}
		if (!itemFound)
			throw new IllegalArgumentException("Value " + value + "not found in the Tree");
		return Arrays.asList(current, parent);

	}

	public boolean isEmpty() {
		return root == null;
	}

	public void printLevelOrder() {
		if (isEmpty())
			throw new IllegalStateException("Can not traverse empty Tree");
		QueueList<BinaryTreeNode<T>> queue = new QueueList<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<T> currentNode = queue.peek();
			System.out.println("printLevelOrder:Found tree node " + currentNode.getValue());
			if (currentNode.getLeft() != null) {
				queue.enqueue(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				queue.enqueue(currentNode.getRight());
			}
			queue.dequeue();
		}
	}

	public void printPreOrder() {
		if (isEmpty())
			throw new IllegalStateException("Can not traverse empty Tree");

		printPreOrderRecursively(root);

	}

	private void printPreOrderRecursively(BinaryTreeNode<T> node) {
		if (node == null)
			return;
		System.out.println("printPreOrder: Found tree node " + node.getValue());
		printPreOrderRecursively(node.getLeft());
		printPreOrderRecursively(node.getRight());
	}

	public void printPostOrder() {
		if (isEmpty())
			throw new IllegalStateException("Can not traverse empty Tree");

		printPostOrderRecursively(root);

	}

	private void printPostOrderRecursively(BinaryTreeNode<T> node) {
		if (node == null)
			return;
		printPostOrderRecursively(node.getLeft());
		printPostOrderRecursively(node.getRight());
		System.out.println("printPostOrder: Found tree node " + node.getValue());
	}

	public void printInOrder() {
		if (isEmpty())
			throw new IllegalStateException("Can not traverse empty Tree");

		printInOrderRecursively(root);

	}

	private void printInOrderRecursively(BinaryTreeNode<T> node) {
		if (node == null)
			return;
		printInOrderRecursively(node.getLeft());
		System.out.println("printInOrder: Found tree node " + node.getValue());
		printInOrderRecursively(node.getRight());
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null || ! (object instanceof BinarySearchTree)) {
			return false;
		}
		
		BinarySearchTree<T> other = (BinarySearchTree<T>) object;
		BinaryTreeNode<T> otherNode = other.root;
		BinaryTreeNode<T> node = this.root;
		
		return checkEquals(node,otherNode);
	}

	private boolean checkEquals(BinaryTreeNode<T> node, BinaryTreeNode<T> otherNode) {
		//System.out.println("valindaing node");
		if((node == null && otherNode != null) || (node != null && otherNode == null)) {
			return false;
		}
		if(node == null && otherNode == null)
			return true;
		if(node.getValue().compareTo(otherNode.getValue()) == 0 ) {
			return checkEquals(node.getLeft(), otherNode.getLeft()) && checkEquals(node.getRight(), otherNode.getRight());
		}else {
			return false;
		}
	}
	//find kth smallest, 1 means smallest , 2 means 2nd smallest and so on
	public T findSmallest(int k) {
		if(isEmpty())
			throw new IllegalStateException("Can not traverse empty tree");
		if(k <=0)
			throw new IllegalArgumentException("Pass valid kth index for smallest item in tree");
		//in case there is only one element, that will be 1st 2nd 3rd .. smallest number
		List<BinaryTreeNode<T>> allSmallestNodes = new ArrayList<>();
		insertInOrder(root, allSmallestNodes);
		int size = allSmallestNodes.size();
		if(size <= k) {
			return allSmallestNodes.get(size-1).getValue();
		}else {
			return allSmallestNodes.get(k-1).getValue();
		}
	}
	//we know in order is sorted based on comparator
	private void insertInOrder(BinaryTreeNode<T> node,List<BinaryTreeNode<T>> sortedNodesList) {
		if(node == null)
			return;
		insertInOrder(node.getLeft(), sortedNodesList);
		sortedNodesList.add(node);
		insertInOrder(node.getRight(), sortedNodesList);
	}
	
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		sizeUsingInOrder(root);
		return size;
	}
	
	private void sizeUsingInOrder(BinaryTreeNode<T> node) {
		if(node == null) {
			return;
		}
		size++;
		sizeUsingInOrder(node.getLeft());
		sizeUsingInOrder(node.getRight());
	}

	//take all teh nodes and transfomr to <R> type, we can do lot of thing this way in single method
	//examples: find firstname of Person Node, find sum of ages etc
	public <R,S> S  traverseAndManipulate(Function<T, R> transformation, Function<List<R>, S> finishser) {
		if(isEmpty()) {
			throw new IllegalStateException("Can not traverse empty tree");
		}
		List<R> collect = new ArrayList<>();
		
		transformUsingPreOrder(root, transformation, collect);
		return finishser.apply(collect);
	}
	
	private <R> void transformUsingPreOrder(BinaryTreeNode<T> node,Function<T, R> transformation, List<R> collect) {
		if(node == null) {
			return;
		}
		collect.add(transformation.apply(node.getValue()));
		transformUsingPreOrder(node.getLeft(),transformation,collect);
		transformUsingPreOrder(node.getRight(),transformation,collect);
	}
	
}
