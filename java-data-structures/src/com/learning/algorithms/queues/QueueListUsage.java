package com.learning.algorithms.queues;

public class QueueListUsage {
	public static void main(String[] args) {
		QueueList<Integer> queue = new QueueList<>();
		for (int i = 1; i <= 7; i++)
			queue.enqueue(i);
		System.out.println("peek first "+queue.peek());
		System.out.println("peek second "+queue.peek());
		System.out.println("initial size "+queue.size());
		
		for (int i = 1; i <= 7; i++) {
			System.out.println("popping continuously "+queue.dequeue());
			System.out.println("size now "+queue.size());
		}
		System.out.println("final size "+queue.size());
	}
}
