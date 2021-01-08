package com.learning.algorithms.queues;

import com.learning.algorithms.singlelinkedlist.SingleLinkedList;

public class QueueList<T>{

	private SingleLinkedList<T> storage;
	
	private int position;
	
	public QueueList() {
		storage = new SingleLinkedList<>();
	}
	
	public void enqueue(T element) {
		//insert at tail O(1)
		storage.insert(element);
		position++;
	}
	
	//find element at head -> O(1)
	public T peek() {
		if(isEmpty())
			throw new IllegalStateException("Queue is Empty");
		return storage.findElementAtHead();
	}
	
	//remove form head O(1)
	public T dequeue() {
		if(isEmpty())
			throw new IllegalStateException("Queue is Empty");
		position--;
		return  storage.removeHead();
	}
	
	public boolean isEmpty() {
		return position == 0;
	}
	public int size() {
		return position;
	}
}
