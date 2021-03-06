package com.learning.algorithms.binarytrees;

public class BinaryTreeNode<T> {

	private T value;
	
	private BinaryTreeNode<T> left;
	
	private BinaryTreeNode<T> right;

	public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	public static enum RelationType{
		SMALLER,LARGER
	}
	
}
