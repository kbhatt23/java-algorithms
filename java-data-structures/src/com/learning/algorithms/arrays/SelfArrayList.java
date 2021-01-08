package com.learning.algorithms.arrays;

public class SelfArrayList<T> {
	//private static final int DEFAULT_SIZE=5;
	private static final int DEFAULT_SIZE=10;
	// private T[] storage ;
	private Object[] storage;
	private int position=0;

	public SelfArrayList() {
		storage=new Object[DEFAULT_SIZE];
	}

	public SelfArrayList(int size) {
		if(size <=0) {
			throw new IllegalArgumentException("Size of arraylist can not be 0 or negative, passed value: "+size);
		}
		storage=new Object[size];
	}
	
	public void add(T t) {
		//increase size of array
		if(isFull()) {
			growArray();
		}
		storage[position] = t;
		position++;
	}
	//add means always chekc if array is full and if yes increas size
	public void add(T t, int index) {
		//increase size of array
		if(isFull()) {
			growArray();
		}
		if(index >position) {
			index = position;
		}
		T oldValue = (T)storage[index];
		storage[index] = t;
		position++;
		for(int i = index+1 ; i <position; i++) {
			T currentVal =(T) storage[i];
			storage[i] = oldValue;
			oldValue=currentVal;
		}
		
	}
	
	public T get(int index) {
		return (T)storage[index];
	}
	
	//just double the array size
	private void growArray() {
		int newLength = storage.length;
		newLength = (newLength/2)+newLength;
		System.out.println("growing array to size "+newLength);
		Object[] newArray = new Object[newLength];
		for(int i=0 ; i < storage.length ; i++) {
			newArray[i]=storage[i];
		}
		storage = newArray;
	}

	public int size() {
		return position;
	}
	
	public void printAll() {
		for(int i =0  ; i < position ; i++) {
			System.out.println("found element "+storage[i]);
		}
	}
	public void remove(int index) {
		if(index >=position) {
			throw new IllegalArgumentException("Index out of bound, passed index: "+index);
		}
		for(int i = index; i < position-1 ; i++) {
			storage[i] = storage[i+1];
		}
		position--;
	}
	
	public boolean isEmpty() {
		return position==0;
	}
	
	public boolean isFull() {
		return position >= storage.length;
	}

}
