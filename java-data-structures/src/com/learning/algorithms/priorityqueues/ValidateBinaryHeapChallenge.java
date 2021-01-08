package com.learning.algorithms.priorityqueues;

public class ValidateBinaryHeapChallenge {
public static void main(String[] args) {
	BinaryHeap<Integer> heap= new BinaryHeap<>();
	heap.insert(23);
	heap.insert(32);
	heap.insert(55);
	heap.insert(34);
	heap.insert(12);
	heap.insert(63);
	heap.insert(24);
	heap.insert(63);
	heap.insert(68);
	
	System.out.println("Validation heap result "+BinaryHeap.validateMinHeap(heap));
}
}
