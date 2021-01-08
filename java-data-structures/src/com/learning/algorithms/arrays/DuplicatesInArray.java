package com.learning.algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {
public static void main(String[] args) {
	//String[] array = new String[] {"one","two","three","four","one","three"};
	Integer[] array = new Integer[] {2,3,1,2,4,3};
	int count = findDuplicateCount(array);
	System.out.println("deplicate count "+count);
	System.out.println("duplcate items "+findDuplicateItems(array));
}

private static <T> int findDuplicateCount(T[] array) {
	//duplicte based on equals m ethodonly , hashcode shud be maintained as well as we are using hashset for this task
	
	Set<T> traversed = new HashSet<>();
	int duplicateCount=0;
	for(T entry: array) {
		if(!traversed.contains(entry)) {
			traversed.add(entry);
		}else {
			duplicateCount++;
		}
	}
	return duplicateCount;
}

private static <T> Set<T>  findDuplicateItems(T[] array) {
	//duplicte based on equals m ethodonly , hashcode shud be maintained as well as we are using hashset for this task
	Set<T> duplicates = new HashSet<>();
	Set<T> traversed = new HashSet<>();

	for(T entry: array) {
		if(!traversed.contains(entry)) {
			traversed.add(entry);
		}else {
			duplicates.add(entry);
		}
	}
	return duplicates;
}
}
