package com.learning.algorithms.singlelinkedlist;

public class SingleLinkedListUsage {
	public static void main(String[] args) {
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
		singleLinkedList.insert(23);
		singleLinkedList.insert(33);
		singleLinkedList.insertHead(1);
		singleLinkedList.insert(66);
		
		//index insertion
		singleLinkedList.insert(77,0);
		singleLinkedList.insert(108,100000000);
		
		System.out.println("size is "+singleLinkedList.size());
		singleLinkedList.printAll();
	}
}
