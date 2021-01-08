package com.learning.algorithms.hashes;

import com.learning.algorithms.binarysearchtrees.Person;

public class HAshTableCollisionUSage {
public static void main(String[] args) {
	SelfHashTable<Person, String> hashTable = new SelfHashTable<>();
	
	String name = "radha";
	Person p1 = new Person(name, "krishna", 101);
	Person p2 = new Person(name, "madhav", 108);
	Person p3 = new Person("Aa", "shankar", 101);
	Person p4 = new Person("BB", "krramishna", 101);
	System.out.println("first time"+hashTable.insert(p1, "one"));
	System.out.println("first time"+hashTable.insert(p2, "two"));
	System.out.println("first time"+hashTable.insert(p3, "three"));
	System.out.println("first time"+hashTable.insert(p4, "four"));
	System.out.println(hashTable.size());
	System.out.println("fetching in collision");
	System.out.println(hashTable.get(p1));
	System.out.println(hashTable.get(p2));
	System.out.println(hashTable.get(p3));
	System.out.println(hashTable.get(p4));
	
}
}
