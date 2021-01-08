package com.learning.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//anagram are words that have all the charachters present in both string and charachter count is same
public class AnagramCheck {
	public static void main(String[] args) {
		String str1 = "restful1";
		String str2 = "fluster";
System.out.println(isAnagramV1(str1, str2)); 
System.out.println(isAnagramV2(str1, str2)); 
	}

	public static boolean isAnagramV1(String str1, String str2) {
		str1 = cleanString(str1);
		str2 = cleanString(str2);
		Map<Character, Integer> countMap1 = countMap(str1);
		Map<Character, Integer> countMap2 = countMap(str2);
		//equals means size of map shud be equal , and each key shud be present
		return countMap1.equals(countMap2);

	}
	
	public static boolean isAnagramV2(String str1, String str2) {
		str1 = cleanString(str1);
		str2 = cleanString(str2);
		//if we sort char array then all same chars are together and hence to check the count  just check equals of string 
		String sortedCharsSt1 = sortedArrayOfchars(str1);
		String sortedCharsSt2 = sortedArrayOfchars(str2);
		//equals of sorted char string means size of chars are same and exact match of set of chars
		return sortedCharsSt2.equals(sortedCharsSt1);

	}

	private static String sortedArrayOfchars(String str1) {
		char[] charArray = str1.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public static String cleanString(String str) {
		// str = str.trim();
		return str.replaceAll("\\W", "");
	}

	private static Map<Character, Integer> countMap(String str) {
		Map<Character, Integer> countMap = new HashMap<>();

		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		return countMap;
	}
}
