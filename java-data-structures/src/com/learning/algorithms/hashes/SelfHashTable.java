package com.learning.algorithms.hashes;

public class SelfHashTable<K, V> {

	private HashNode<K, V>[] storage;

	// based on load factor we will increase array size and rehash
	private static final int MAX_SIZE = 10;

	private int size = 0;

	// if 75 percent items are loaded we increase size so that lesser chance of
	// collision
	private final double loadFactor;

	public SelfHashTable() {
		storage = new HashNode[MAX_SIZE];
		loadFactor = 0.75;
	}

	public SelfHashTable(int size) {
		storage = new HashNode[size];
		loadFactor = 0.75;
	}

	public SelfHashTable(int size, double loadFactor) {
		storage = new HashNode[size];
		this.loadFactor = loadFactor;
	}

	// returns null if inserted first time, return old value if updated old value
	// TODO: write code for growing and rhashsing based on load factor
	public V insert(K key, V value) {
		int index = extractHashIndex(key);

		HashNode<K, V> existingNode = storage[index];
		HashNode<K, V> newHashNode = new HashNode<>(key, value, null);
		if (existingNode == null) {
			// insert new entry
			storage[index] = newHashNode;
		} else {
			while (existingNode != null) {
				if (existingNode.getKey().equals(key)) {
					// update existing
					V existing = existingNode.getValue();
					existingNode.setValue(value);
					return existing;
				}
				if (existingNode.getNext() == null) {
					existingNode.setNext(newHashNode);
					break;
				}
				existingNode = existingNode.getNext();
			}
		}
		size++;
		return null;
	}

	public V get(K key) {
		int index = extractHashIndex(key);
		HashNode<K, V> hashNodeFound = storage[index];
		V valueFound = null;
		if (hashNodeFound != null) {
			while (hashNodeFound != null) {
				if (hashNodeFound.getKey().equals(key)) {
					valueFound = hashNodeFound.getValue();
					break;
				}
				hashNodeFound = hashNodeFound.getNext();
			}
		}
		return valueFound;
	}

	private int extractHashIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % storage.length;
		return index;
	}

	public int size() {
		return size;
	}

	// return null if key is not found otherwise returns the value
	public V remove(K key) {
		if(key == null)
			return null;
		int index = extractHashIndex(key);
		HashNode<K, V> foundNode = storage[index];
		if(foundNode == null) {
			return null;
		}
		//single item present
		if(foundNode.getNext() == null) {
			if(foundNode.getKey().equals(key)) {
			storage[index] = null;
			size--;
			}
			else 
				foundNode=null;
		}
		//more than one elemnt present
		else {
		HashNode<K, V> foundNodeParent = null;
		while(foundNode != null) {
			if(foundNode.getKey().equals(key)) {
				if(foundNodeParent != null){
					foundNodeParent.setNext(foundNode.getNext());
				}else {
					storage[index]= foundNode.getNext();
				}
				size--;
				break;
			}
			foundNodeParent=foundNode;
			foundNode=foundNode.getNext();
		}}
		return (foundNode == null) ? null: foundNode.getValue();
	}
}
