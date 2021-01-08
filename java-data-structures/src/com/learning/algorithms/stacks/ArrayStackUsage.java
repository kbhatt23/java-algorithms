package com.learning.algorithms.stacks;

public class ArrayStackUsage {
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>(5);
		for (int i = 1; i <= 7; i++)
			stack.push(i);
		System.out.println("peek first "+stack.peek());
		System.out.println("peek second "+stack.peek());
		
		System.out.println(stack.pop());
		System.out.println("peek third "+stack.peek());
		System.out.println("pop fourth "+stack.pop());
		System.out.println("peek fifth "+stack.peek());
		
		System.out.println("size after first functionaluty "+stack.size());
		System.out.println("=========================");
		for (int i = 1; i <= 7; i++)
			System.out.println(stack.pop());
	}
}
