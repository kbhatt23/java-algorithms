package com.learning.algorithms.binarysearchtrees;

import java.util.List;
import java.util.function.Function;

public class BinarySearchPersonAgeSum2 {
public static void main(String[] args) {
	List<Person> persons = Person.generate();
	
	BinarySearchTree<Person> tree = new BinarySearchTree<>();
	persons.forEach(tree::add);
	List<Integer> allAgesList = tree.traverseAndManipulate(person -> person.getAge(),Function.identity());
	System.out.println("all ages list "+allAgesList);

	System.out.println("sum of ages "+allAgesList.stream().mapToInt(t -> t).sum());
	
	System.out.println("size of nodes "+tree.traverseAndManipulate(person -> person.getAge(), i-> i.size()));
}
}
