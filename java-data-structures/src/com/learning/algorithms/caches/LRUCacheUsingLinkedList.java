package com.learning.algorithms.caches;

import java.util.HashMap;
import java.util.Map;

//in lru cahce , u just put data and find data, older accesed data will get removed on its own
public class LRUCacheUsingLinkedList<K, V> {

	// value , insert item at head and hence tail is always lowest, check size and
	// clean old as it is double linked list
	private DoublyLinkedNode<K, V> headNode;

	private DoublyLinkedNode<K, V> tailNode;

	private final int maxSize;

	private static final int DEFAULT_MAX_SIZE = 5;

	private int size;

	// used for updating item in O(1) otherwise we had to iterate from head to n
	// elemtn to check if item exists
	private Map<K, DoublyLinkedNode<K, V>> hashes;

	public LRUCacheUsingLinkedList(int maxSize) {
		hashes = new HashMap<>();
		this.maxSize = maxSize;
	}

	public LRUCacheUsingLinkedList() {
		hashes = new HashMap<>();
		maxSize = DEFAULT_MAX_SIZE;
	}

	public void put(K key, V value) {
		// hashtable comes handy O(1)
		if (hashes.containsKey(key)) {
			upddateExistingNode(key, value);
		} else {
			insertEntry(key, value);
		}
	}

	private void insertEntry(K key, V value) {
		// new node added at head will have previos as null and next as current headNode
		DoublyLinkedNode<K, V> valueNode = new DoublyLinkedNode<>(key, value, null, headNode);
		// new entry add to head
		if (headNode == null) {
			// completely empty table
			headNode = valueNode;
			tailNode = valueNode;
			size++;
		} else {
			// ther exist atleast one element
			// first check if we need to remove item from tail
			if (size >= maxSize) {
				removeTailNode();
			}
			// just insert a node at the head
			DoublyLinkedNode<K, V> currentHeadNode = headNode;
			currentHeadNode.setPrevious(valueNode);
			headNode = valueNode;
			size++;
		}
		hashes.put(key, valueNode);
	}

	private void upddateExistingNode(K key, V value) {
		DoublyLinkedNode<K, V> existingNode = hashes.get(key);
		if (headNode == tailNode) {
			// only one item present
			// only update will do the job, should also update the object present in hash
			existingNode.setValue(value);
		} else {
			// atleast 2 items present
			existingNode.setValue(value);
			// reorder the access order , only if it is already not head
			if (existingNode != headNode) {
				if (headNode.getNext() == tailNode) {
					// only 2 items present, swap head and tail
					tailNode = headNode;
				}
				DoublyLinkedNode<K, V> currentHeadNode = headNode;
				headNode = existingNode;
				currentHeadNode.setPrevious(existingNode);
				if (existingNode.getNext() != null)
					existingNode.getNext().setPrevious(existingNode.getPrevious());
				if(existingNode.getPrevious() != null)
					existingNode.getPrevious().setNext(existingNode.getNext());
				existingNode.setNext(currentHeadNode);
			}
		}
	}

	private void removeTailNode() {
		// remove tail
		if (headNode == tailNode) {
			// only one item present
			removeCache();
		} else {
			DoublyLinkedNode<K, V> currentTailNode = tailNode;
			tailNode = currentTailNode.getPrevious();
			currentTailNode.getPrevious().setNext(null);
			currentTailNode.setPrevious(null);
			hashes.remove(currentTailNode.getKey());
			size--;
		}
	}

	public void removeCache() {
		size=0;
		headNode = null;
		tailNode = null;
		hashes = null;
	}

	public V get(K key) {
		DoublyLinkedNode<K, V> nodeFound = hashes.get(key);
		//also update the acces order to publish the item to head of linked list
		if(nodeFound != null)
			upddateExistingNode(nodeFound.getKey(), nodeFound.getValue());
		return nodeFound == null ? null : nodeFound.getValue();
	}

	public int size() {
		return size;
	}
	
	public void printCacheInOrder() {
//		if(headNode == null)
//			throw new IllegalStateException("Can not iterate empty cache");
		DoublyLinkedNode<K, V> node = headNode;
		while(node != null) {
			System.out.println("Found element "+node.getKey()+" : "+node.getValue());
			node=node.getNext();
		}
	}
}
