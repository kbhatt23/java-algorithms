package com.learning.algorithms.caches;

public class LRUCacheUsingLinkedListUsage {
public static void main(String[] args) {
	LRUCacheUsingLinkedList<Integer, String> cache = new LRUCacheUsingLinkedList<>(5);
	
	cache.put(1, "one");
	cache.put(2, "two");
	cache.put(3, "three");
	cache.put(4, "four");
	cache.put(5, "five");
	cache.put(6, "six");
	cache.put(1, "one updated");
	
	cache.put(2, "two updated");
	cache.put(3, "three updated");
	
	
	System.out.println(cache.get(1));
	System.out.println(cache.get(2));
	System.out.println(cache.get(3));
	System.out.println(cache.get(4));
	System.out.println(cache.get(5));
	System.out.println(cache.get(6));
	System.out.println(cache.get(7));
	System.out.println("final size "+cache.size());
	System.out.println("final cache behavior");
	cache.printCacheInOrder();
}
}
