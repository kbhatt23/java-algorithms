package com.learning.algorithms.stacks;

public class StackListUsage {
	public static void main(String[] args) {
		StackList<Integer> stack = new StackList<>();
		for (int i = 1; i <= 7; i++)
			stack.push(i);
		System.out.println("peek first "+stack.peek());
		System.out.println("peek second "+stack.peek());
		System.out.println("initial size "+stack.size());
		
		for (int i = 1; i <= 7; i++) {
			System.out.println("popping continuously "+stack.pop());
			System.out.println("size now "+stack.size());
		}
		System.out.println("final size "+stack.size());
	}
}
