package com.learning.algorithms.hashes;

public class HashTableInsertUsage {
public static void main(String[] args) {
	SelfHashTable<Integer, String> hashTable = new SelfHashTable<>();
	
	System.out.println("insert result "+hashTable.insert(1, "one"));
	System.out.println("insert result "+hashTable.insert(2, "two"));
	System.out.println("insert result "+hashTable.insert(3, "three"));
	System.out.println("insert result "+hashTable.insert(1, "one updated"));
	
	System.out.println("first fetch result "+hashTable.get(4));
}
}
