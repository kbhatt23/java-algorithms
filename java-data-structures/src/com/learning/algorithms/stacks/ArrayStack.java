package com.learning.algorithms.stacks;

public class ArrayStack<T> {
	// private static final int DEFAULT_SIZE=5;
	private static final int DEFAULT_SIZE = 10;

	private Object[] storage;

	private int position;

	public ArrayStack() {
		storage = new Object[DEFAULT_SIZE];
	}

	public ArrayStack(int size) {
		storage = new Object[size];
	}

	public void push(T element) {
		if (isFull())
			growArray();
		storage[position] = element;
		position++;
	}

	public T peek() {
		if(isEmpty())
			throw new IllegalStateException("Stack is Empty");
		return (T) storage[position-1];
	}
	
	public T pop() {
		if(isEmpty())
			throw new IllegalStateException("Stack is Empty");
		//also we shud make the value to be null so that it become avaiable for G.C
		
		T element = (T)storage[position-1] ;
		storage[position-1] = null;
		position--;
		return  element;
	}

	public boolean isEmpty() {
		return position == 0;
	}

	public boolean isFull() {
		return position >= storage.length;
	}

	// just double the array size
	private void growArray() {
		int newLength = storage.length;
		newLength = (newLength / 2) + newLength;
		System.out.println("growing array to size " + newLength);
		Object[] newArray = new Object[newLength];
		for (int i = 0; i < storage.length; i++) {
			newArray[i] = storage[i];
		}
		storage = newArray;
	}

	public int size() {
		return position;
	}
}
