package com.learning.algorithms.stacks;

import com.learning.algorithms.singlelinkedlist.SingleLinkedList;

//no need of storage as we will use linked list
//even single linked list will do the job
public class StackList<T> {

	private SingleLinkedList<T> storage;

	//so that size can be O(1), size is infinite
	private int position;

	public StackList() {
		storage = new SingleLinkedList<>();
	}

	//while inserting at the tail and fetching from tail pop can be o(n) while popping
	//hence using insert and remove at the head instead
	public void push(T element) {
		//storage.insert(element);
		storage.insertHead(element);
		position++;
	}

	//while inserting at the tail and fetching from tail pop can be o(n)
	//hence using insert and remove at the head instead
	public T peek() {
		if(isEmpty())
			throw new IllegalStateException("Stack is Empty");
		//return (T) storage.elementsAtNthIndex(position-1).get(0).getValue();
		return storage.findElementAtHead();
	}
	
	
	
	public T pop() {
		if(isEmpty())
			throw new IllegalStateException("Stack is Empty");
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
