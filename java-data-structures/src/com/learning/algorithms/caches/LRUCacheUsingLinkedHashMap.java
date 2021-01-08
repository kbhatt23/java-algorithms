package com.learning.algorithms.caches;

import java.util.LinkedHashMap;

public class LRUCacheUsingLinkedHashMap<K,V> extends LinkedHashMap<K, V>{

	private static final long serialVersionUID = 2348225589121135950L;
	//used in case if size is more than maxSize we ignore old values
	//if not we size keeps on growing and of no use
	private final int maxSize ;
	
	
	public LRUCacheUsingLinkedHashMap(int maxSize) {
		super(maxSize, 0.75f, true);
		this.maxSize=maxSize;
	}
	
	//this method can help remove old values and keep cache remove items uses least recently 
	//ads perfromance
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		boolean remove = size() > maxSize;
		if(remove)
			System.out.println("Removing eldest elemetn from cache");
		return remove;
	}
	
	
}
