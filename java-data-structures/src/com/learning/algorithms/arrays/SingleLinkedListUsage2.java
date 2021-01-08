package com.learning.algorithms.arrays;

import com.learning.algorithms.singlelinkedlist.SingleLinkedList;

public class SingleLinkedListUsage2 {

	public static void main(String[] args) {
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
		singleLinkedList.insert(23);
		singleLinkedList.insert(20);
		singleLinkedList.insert(99);
		singleLinkedList.remove(2);
		singleLinkedList.remove(new Integer(23));
		singleLinkedList.insertHead(99);
		System.out.println("size after maniuplation "+singleLinkedList.size());
		System.out.println("isempty after maniuplation "+singleLinkedList.isEmpty());
		singleLinkedList.printAll();
	}

}
