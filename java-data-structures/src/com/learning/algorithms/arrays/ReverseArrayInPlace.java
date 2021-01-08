package com.learning.algorithms.arrays;

import java.util.Arrays;

public class ReverseArrayInPlace {
	public static void main(String[] args) {
		Integer[] array = new Integer[] {1,2,3,4,5,6};
		printArray(array);
		System.out.println("=====================");
		reverse(array);
		printArray(array);
		System.out.println("=====================");
		reverseWhile(array);
		printArray(array);
	}
	
	//inplace means reverse without consuming memory/creating new array
	public static  <T> void reverse(T[] array) {
		for(int i=0,j=array.length-1;i < j ; i++,j--) {
			T firstElement = array[i];
			T lastElement = array[j];
			array[i] = lastElement;
			array[j] = firstElement;
		}
		
	}
	public static  <T> void reverseWhile(T[] array) {
		int i = 0;
		int j = array.length-1;
		while(i < j) {
			T firstElement = array[i];
			T lastElement = array[j];
			array[i] = lastElement;
			array[j] = firstElement;
			i++;j--;
		}
		
	}
	
	public static <T> void printArray(T[] array) {
		Arrays.stream(array).forEach(e-> System.out.println("found elmeent "+e));
	}

}
