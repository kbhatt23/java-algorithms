package com.learning.algorithms.arrays;

public class SelfArrayListUsage {

	public static void main(String[] args) {
		SelfArrayList<String> arrayList = new SelfArrayList<>();
		//populateAndGrowAndPrint(arrayList);
		//addToSpecificIndex(arrayList);
	removeUSage(arrayList);
	}

	private static void removeUSage(SelfArrayList<String> arrayList) {
		System.out.println("is empty before adding item "+arrayList.isEmpty());
		System.out.println("is full before adding item "+arrayList.isFull());
		
		for(int i =0 ; i < 5 ; i ++) {
			arrayList.add("jai shree ram "+i);
		}
		System.out.println("is empty after adding item "+arrayList.isEmpty());
		System.out.println("is full after adding item "+arrayList.isFull());
		arrayList.printAll();
		System.out.println("======================================");
		
		arrayList.remove(3);
		arrayList.printAll();
		System.out.println("final size "+arrayList.size());
	}

	private static void addToSpecificIndex(SelfArrayList<String> arrayList) {
		for(int i =0 ; i < 5 ; i ++) {
			arrayList.add("jai shree ram "+i);
		}
		arrayList.printAll();
		System.out.println("======================================");
		arrayList.add("jai shree radhe" , 4);
		arrayList.printAll();
		System.out.println("size is "+arrayList.size());
		System.out.println("last element is "+arrayList.get(arrayList.size()-1));
		
	}

	private static void populateAndGrowAndPrint(SelfArrayList<String> arrayList) {
		for(int i = 0 ; i < 100 ; i++)
		arrayList.add("jai shree ram "+i);
		
		for(int i = 0 ; i < 100 ; i++)
			System.out.println("item found at index "+i+" is: "+arrayList.get(i));
	}

}
