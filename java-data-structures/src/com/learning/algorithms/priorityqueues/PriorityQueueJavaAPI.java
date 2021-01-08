package com.learning.algorithms.priorityqueues;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueJavaAPI {
	public static void main(String[] args) {
		Queue<Integer> intPriorityQueue = new PriorityQueue<>()
				;
		intPriorityQueue.offer(8);
		intPriorityQueue.offer(9);
		intPriorityQueue.offer(4);
		intPriorityQueue.offer(1);
		intPriorityQueue.offer(5);
		System.out.println(intPriorityQueue);

		int size = intPriorityQueue.size();
		for(int i = 0 ; i <size ; i++)
		System.out.println("polling out  element "+intPriorityQueue.poll());
		
		System.out.println(intPriorityQueue);
	}
}
