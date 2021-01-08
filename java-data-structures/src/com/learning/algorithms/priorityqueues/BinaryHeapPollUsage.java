package com.learning.algorithms.priorityqueues;

public class BinaryHeapPollUsage {
	public static void main(String[] args) {
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		System.out.println("initial size "+heap.size());
		//System.out.println("first poll before insertion "+heap.poll());
		heap.insert(5);
		heap.insert(3);
		heap.insert(7);
		heap.insert(2);
		heap.insert(6);
		System.out.println("size "+heap.size());
		System.out.println("first poll before insertion "+heap.poll());
		System.out.println("first poll before insertion "+heap.poll());
		System.out.println("first poll before insertion "+heap.poll());
		System.out.println("first poll before insertion "+heap.poll());
		System.out.println("first poll before insertion "+heap.poll());
	}
}
