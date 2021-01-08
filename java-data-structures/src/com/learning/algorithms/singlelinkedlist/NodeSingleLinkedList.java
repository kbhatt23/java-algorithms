package com.learning.algorithms.singlelinkedlist;

//non circular single linked list
public class NodeSingleLinkedList<T> {

	private T value;
	private NodeSingleLinkedList<T> next;
	public NodeSingleLinkedList(T value, NodeSingleLinkedList<T> next) {
		this.value = value;
		this.next = next;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public NodeSingleLinkedList<T> getNext() {
		return next;
	}
	public void setNext(NodeSingleLinkedList<T> next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "NodeSingleLinkedList [value=" + value + ", next=" + next + "]";
	}
	
//	@Override
//	public String toString() {
//		return "NodeSingleLinkedList [value=" + value +"]";
//	}
	
}
