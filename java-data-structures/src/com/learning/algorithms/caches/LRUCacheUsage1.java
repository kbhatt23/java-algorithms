package com.learning.algorithms.caches;

import java.util.Map;

public class LRUCacheUsage1 {
public static void main(String[] args) {
	Map<Integer, Integer> cache = new LRUCacheUsingLinkedHashMap<>(5);
	
	for(int i = 1; i <=7 ;  i++) {
		cache.put(i, i);
	}
	cache.put(1, 11);
	cache.put(2, 22);
	System.out.println("final size "+cache.size());
	
	for(int i = 1; i <=7 ;  i++) {
		System.out.println("Finding element with key "+i+" : "+cache.get(i));
	}
}
}
