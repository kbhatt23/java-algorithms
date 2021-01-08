package com.learning.algorithms.caches;

//we always insert at header, atail is the oldest and hence we can remove the old item in O(1)
public class DoublyLinkedNode<K,V> {

	private K key;
	private V value;
	
	private DoublyLinkedNode<K,V> previous;
	
	private DoublyLinkedNode<K,V> next;

	public DoublyLinkedNode(K key, V value, DoublyLinkedNode<K, V> previous, DoublyLinkedNode<K, V> next) {
		super();
		this.key = key;
		this.value = value;
		this.previous = previous;
		this.next = next;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public DoublyLinkedNode<K, V> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedNode<K, V> previous) {
		this.previous = previous;
	}

	public DoublyLinkedNode<K, V> getNext() {
		return next;
	}

	public void setNext(DoublyLinkedNode<K, V> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "DoublyLinkedNode [key=" + key + ", value=" + value + "]";
	}
	

	
}