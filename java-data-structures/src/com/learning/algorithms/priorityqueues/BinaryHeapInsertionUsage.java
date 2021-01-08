package com.learning.algorithms.priorityqueues;

public class BinaryHeapInsertionUsage {
	public static void main(String[] args) {
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		System.out.println("initial size "+heap.size());
		heap.insert(5);
		heap.insert(3);
		
		heap.insert(7);
		heap.insert(2);
		heap.insert(6);
		System.out.println("final size "+heap.size());
		System.out.println("min val is "+heap.peek());
	}
}
