package com.learning.algorithms.caches;

public class LRUCacheUsingLinkedListUsage2 {
public static void main(String[] args) {
	LRUCacheUsingLinkedList<Integer, String> cache = new LRUCacheUsingLinkedList<>(1);
	
	cache.put(1, "one");
	cache.put(1, "one updated");
	cache.put(2, "two");
	
	System.out.println(cache.get(1));
	System.out.println("final size "+cache.size());
}
}
