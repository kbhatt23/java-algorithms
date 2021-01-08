package com.learning.algorithms.binarysearchtrees;

import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchPersonAgeSum {
public static void main(String[] args) {
	List<Person> persons = Person.generate();
	
	BinarySearchTree<Person> tree = new BinarySearchTree<>();
	persons.forEach(tree::add);
	List<String> allFirstNames = tree.traverseAndManipulate(person -> person.getFirstName(), 
			a -> a
			);
	System.out.println("allnames list "+allFirstNames);
	
	//lets say we want finisher as well
	String allFirstNamesFormatted = tree.traverseAndManipulate(person -> person.getFirstName(), 
			namesList -> namesList.stream().collect(Collectors.joining(",","(",")"))
			);
	
	System.out.println("formated names :"+allFirstNamesFormatted);
}
}
