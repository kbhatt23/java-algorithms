package com.learning.algorithms.singlelinkedlist;

import java.util.Arrays;
import java.util.List;

public class SingleLinkedList<T> {

	private NodeSingleLinkedList<T> head;

	private NodeSingleLinkedList<T> tail;

	// no value
	public SingleLinkedList() {
	}

	// with first element
	public SingleLinkedList(T value) {
		// head pointing to node with value and null next element
		NodeSingleLinkedList<T> node = new NodeSingleLinkedList<T>(value, null);
		this.head = node;
		this.tail = node;
	}

	private void initializeHeadAndTail(T value) {
		System.out.println("initializing head and tail with node value " + value);
		NodeSingleLinkedList<T> node = new NodeSingleLinkedList<T>(value, null);
		this.head = node;
		this.tail = node;
	}

	// by default inserting means inserting at the end like java linked list
	public void insert(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Node value can not be null");
		}
		if (isEmpty()) {
			initializeHeadAndTail(value);
		} else {
			// tail is the last element, if not used we need to have o(n) complexity
			NodeSingleLinkedList<T> lastElement = this.tail;
			NodeSingleLinkedList<T> newNode = new NodeSingleLinkedList<T>(value, null);
			lastElement.setNext(newNode);
			this.tail = newNode;
		}

	}
	
	public void insertHead(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Node value can not be null");
		}
		if (isEmpty()) {
			initializeHeadAndTail(value);
		} else {
			// tail is the last element, if not used we need to have o(n) complexity
			NodeSingleLinkedList<T> headElement = this.head;
			NodeSingleLinkedList<T> newNode = new NodeSingleLinkedList<T>(value, headElement);
			this.head = newNode;
		}

	}
	//inserting at index position
	public void insert(T value, int index) {
		if (value == null) {
			throw new IllegalArgumentException("Node value can not be null");
		}
		if (isEmpty()) {
			initializeHeadAndTail(value);
		} else {
			List<NodeSingleLinkedList<T>> elementsAtNthIndex = elementsAtNthIndex(index);
			NodeSingleLinkedList<T> currentNode = elementsAtNthIndex.get(0);
			NodeSingleLinkedList<T> previousNode = elementsAtNthIndex.get(1);
			if(currentNode== null && previousNode == null ) {
				//insert at the tail
				insert(value);
			}else if(this.head==currentNode){
				insertHead(value);
			}else {
				NodeSingleLinkedList<T> newNode = new NodeSingleLinkedList<T>(value, currentNode);
				//merge
				previousNode.setNext(newNode);
			}
		}

	}
	
	public T remove(int index) {
		if(isEmpty())
			throw new IllegalArgumentException("Can not Remove Empty linked list Node");
		List<NodeSingleLinkedList<T>> elementsAtNthIndex = elementsAtNthIndex(index);
		remove( elementsAtNthIndex,"Index out of bound, passed value "+index);
		return elementsAtNthIndex.get(0).getValue();
	}
	
	public T removeHead() {
		if(isEmpty())
			throw new IllegalArgumentException("Can not Remove Empty linked list Node");
		NodeSingleLinkedList<T> currentHead = this.head;
		if(currentHead == this.tail) {
			removLinkedList();
		}else {
			this.head = currentHead.getNext();
		}
		return currentHead.getValue();
	}
	
	public T findElementAtHead() {
		if(isEmpty())
			throw new IllegalArgumentException("Can not retrieve Empty linked list");
		return head.getValue();
	}
	
	
	public T remove(T value) {
		if(isEmpty())
			throw new IllegalArgumentException("Can not Remove Empty linked list Node");
		List<NodeSingleLinkedList<T>> elementsAtNthIndex = elementsWithValue(value);
		remove( elementsAtNthIndex,"Item not found in list, passed value "+value);
		return elementsAtNthIndex.get(0).getValue();
	
	}

	private void remove( List<NodeSingleLinkedList<T>> elementsAtNthIndex, String itemNotFoundmsg) {
		NodeSingleLinkedList<T> currentNode = elementsAtNthIndex.get(0);
		NodeSingleLinkedList<T> previousNode = elementsAtNthIndex.get(1);
		if(currentNode== null && previousNode == null ) {
			throw new IllegalArgumentException(itemNotFoundmsg);
		}else if(this.head==currentNode){
			if(this.head==this.tail) {
				//single elemtn present
				removLinkedList();
			}else {
				//more than one element present
				this.head=currentNode.getNext();
			}
		}
		else if(this.tail == currentNode) {
			previousNode.setNext(null);
			this.tail=previousNode;
		}
		else {
			previousNode.setNext(currentNode.getNext());
		}
	}
	public void removLinkedList() {
		this.head=this.tail=null;
	}

	public List<NodeSingleLinkedList<T>> elementsAtNthIndex(int index){
		NodeSingleLinkedList<T> previous = null;
		NodeSingleLinkedList<T> current = this.head;
		int i=0;
		//if we pass out of range
		while(current != null) {
			if(index == i) {
				return Arrays.asList(current,previous);
			}
			previous = current;
			current=current.getNext();
			i++;
		}
		//index not found and hence adding at the tail 
		//pass both as null
		return Arrays.asList(null,null);
		
	}
	
	private List<NodeSingleLinkedList<T>> elementsWithValue(T value){
		NodeSingleLinkedList<T> previous = null;
		NodeSingleLinkedList<T> current = this.head;
		//if we pass out of range
		while(current != null) {
			if(current.getValue().equals(value)) {
				return Arrays.asList(current,previous);
			}
			previous = current;
			current=current.getNext();
		}
		//index not found and hence adding at the tail 
		//pass both as null
		return Arrays.asList(null,null);
		
	}
	//better approach
	public NodeSingleLinkedList<T> findMiddleNode(){
		if(isEmpty())
			throw new IllegalStateException("Linked List is empty");
		NodeSingleLinkedList<T> middleNode = this.head;
		NodeSingleLinkedList<T> fastNode = this.head;
		
		//iterate one by one till last
		while(middleNode != null) {
		//while(fastNode==null||fastNode.getNext() == null) {
			//last element for double speed means middle element can be returned
			if(fastNode==null||fastNode.getNext() == null) {
				break;
			}
			
			middleNode = middleNode.getNext();
			if(fastNode.getNext() != null) {
				fastNode = fastNode.getNext().getNext();
			}else {
				fastNode=null;
			}
		}
		
		return middleNode;
	}
	
	
	public void printReverse() {
		printRecursively(this.head);
		
	}
	
	private void printRecursively(NodeSingleLinkedList<T> current) {
		if (current == null) {
			return;
		}
		printRecursively(current.getNext());
		System.out.println("Found element " + current.getValue());

	}
	
	public void reverse() {
		NodeSingleLinkedList<T> currentHead = this.head;
		reverseNodesRecursively(currentHead);
		this.tail=currentHead;
		
		
	}
	
	private void reverseNodesRecursively(NodeSingleLinkedList<T> current) {
		if (current == null) {
			return;
		}
		NodeSingleLinkedList<T> nextNode = current.getNext();
		if(nextNode == null) {
			//put as tail
			this.head=current;
		}else {
			reverseNodesRecursively(nextNode);
			nextNode.setNext(current);
			current.setNext(null);
		}

	}
	
	public int size() {
		int size = 0; 
		NodeSingleLinkedList<T> current = this.head;
		while(current != null) {
			current = current.getNext();
			size++;
		}
		
		return size;
	}
	
	public void printAll() {
		NodeSingleLinkedList<T> current = this.head;
		int index=0;
		while(current != null) {
			System.out.println("Node Found at index "+index+ " : "+current);
			current = current.getNext();
			index++;
		}
	}

	public boolean isEmpty() {
		return this.head == null || this.tail == null;
	}

}
