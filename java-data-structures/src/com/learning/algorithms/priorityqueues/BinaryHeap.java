package com.learning.algorithms.priorityqueues;

public class BinaryHeap<T extends Comparable<T>> {

	private Object[] storage;
	
	public static final int MAX_SIZE=10;
	
	private int position;
	
	public BinaryHeap() {
		storage=new Object[MAX_SIZE];
	}
	//min heap just like java priority queue
	//insert is O(log n)
	public void insert(T value) {
		//just add at the end of array and do heapification to the top
		//O(1)+O(log n)

		if(isFull())
			throw new IllegalStateException("Heap is full");
		
		storage[position++] = value;
		
		//heapifyFromBottomRecursion(position-1);
		heapifyFromBottom(position-1);
	}
	
	private void heapifyFromBottom(int childIndex) {
		while(childIndex > 0) {
			int parentIndex = (childIndex-1)/2;
			T parentObject = (T)storage[parentIndex];
			T childObject = (T)storage[childIndex];
			if(parentObject.compareTo(childObject) > 0) {
				//swap
				storage[parentIndex] = childObject;
				storage[childIndex] = parentObject;
			}
			childIndex=parentIndex;
		}
		
		
	}
	//O(1) for min heap
	public T peek() {
		if(isEmpty())
			throw new IllegalStateException("Can not traverse empty heap");
		return (T)storage[0];
	}
	
	public boolean isEmpty() {
		return position == 0;
	}
	
	//O(log n ) becauis of swapping
	public T poll() {
		T data = peek();
		storage[0]= storage[position-1];
		heapifyFromTop(0);
		position--;
		return data;
		
	}
	
	private void heapifyFromTop(int parentIndex) {
		if(parentIndex > size()) {
			return;
		}
		int leftIndex = (2*parentIndex)+1;
		int rightIndex = (2*parentIndex)+2;
		T leftObject = (T)storage[leftIndex];
		T rightObject = (T)storage[rightIndex];
		T parentObject = (T)storage[parentIndex];
		T objectToSwap =null;
		int nextIndex = parentIndex;
//		if(leftObject!= null && rightObject != null && leftObject.compareTo(rightObject) < 0) {
//			objectToSwap=leftObject;
//			nextIndex=leftIndex;
//		}else if(leftObject!= null && rightObject != null && rightObject.compareTo(leftObject) < 0){
//			objectToSwap=rightObject;
//			nextIndex=rightIndex;
//		}
		
		if(leftIndex < position && leftObject!= null && leftObject.compareTo(parentObject) < 0 ) {
			nextIndex=leftIndex;
		}
		if(rightIndex < position && rightObject!= null && rightObject.compareTo(parentObject) < 0 ) {
			nextIndex=rightIndex;
		}
		
		if(parentIndex != nextIndex) {
			storage[nextIndex] = parentIndex;
			storage[parentIndex] = objectToSwap;
			heapifyFromTop(nextIndex);
		}
	
	}
	private void heapifyFromBottomRecursion(int childIndex) {
		if(childIndex <= 0 ) {
			return;
		}
		int parentIndex = (childIndex-1)/2;
			T parentObject = (T)storage[parentIndex];
			T childObject = (T)storage[childIndex];
			if(parentObject.compareTo(childObject) > 0) {
				//swap
				storage[parentIndex] = childObject;
				storage[childIndex] = parentObject;
			}
			heapifyFromBottomRecursion(parentIndex);
	}

	public boolean isFull() {
		return position >= MAX_SIZE;
	}
	
	public int size() {
		return position;
	}
	//validate if heap is minheap
	public static <R extends Comparable<R>> boolean validateMinHeap(BinaryHeap<R> heap) {
		if(heap.isEmpty())
			throw new IllegalStateException("Can not traverse empty heap");
		int size = heap.size();
		boolean isValidMinHeap = true;
		for(int i=0;i<size ; i++) {
			int leftIndex=(2*i)+1;
			int rightIndex=(2*i)+2;
			if(leftIndex >= size || rightIndex >= size) {
				continue;
			}
			R parentObject = (R)heap.storage[i];
			R leftChildObject = (R)heap.storage[leftIndex];
			R rightChildObject = (R)heap.storage[rightIndex];
			if(leftChildObject != null && (parentObject.compareTo(leftChildObject) > 0
					)) {
				isValidMinHeap=false;
				break;
			}
			if(rightChildObject != null && (parentObject.compareTo(rightChildObject) > 0
					)) {
				isValidMinHeap=false;
				break;
			}
		}
		return isValidMinHeap;
	}
	
} 
