package com.learning.algorithms.hashes;

import java.util.HashSet;
import java.util.Set;

public class TwoSumProblem {
	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5,6,7};
		
		pairOfSums(numbers, 4);
		pairOfSumsBad(numbers, 4);
	}

	public static void pairOfSums(int[] numbers, int expectedSum) {
		//Map<Integer, Integer> iterationMap = new HashMap<>();
		Set<Integer> iterationSet = new HashSet<>();
		for(int i =0; i < numbers.length; i++) {
			int current = numbers[i];
			int remainder = expectedSum-current;
			if(iterationSet.contains(remainder)) {
				//found element
				System.out.println("good: Sum of "+current+" and "+remainder+" = "+expectedSum);
			}
			iterationSet.add( current);
		}
	}
	
	public static void pairOfSumsBad(int[] numbers, int expectedSum) {
		Set<Integer> foundIndexes = new HashSet<>();
		for(int i =0; i < numbers.length; i++) {
			int current = numbers[i];
			for(int j = 0 ; j<numbers.length ; j++) {
				//ignore itself
				if(j == i || foundIndexes.contains(i) || foundIndexes.contains(j))
					continue;
				int other = numbers[j];
				if(other + current == expectedSum) {
					System.out.println("bad: Sum of "+current+" and "+other+" = "+expectedSum);
					foundIndexes.add(i);foundIndexes.add(j);
				}
			}
		}
	}
}
