package com.learning.algorithms.singlelinkedlist.challenges;

import com.learning.algorithms.singlelinkedlist.SingleLinkedList;

public class FindMidOfSingleLinkedList {
	public static void main(String[] args) {
		SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		System.out.println("middle node is " + linkedList.findMiddleNode());

		System.out.println("===================");
		linkedList.printReverse();
		
		
	}

}
