package com.learning.algorithms.binarysearchtrees;

import java.util.Arrays;
import java.util.List;

public class Person implements Comparable<Person>{

	private String firstName;

	private String lastName;

	private int age;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	
	public static List<Person> generate(){
		return Arrays.asList(new Person("shree", "ram", 108),
				new Person("radhe", "krishna", 101),
				new Person("uma", "shankar", 107)
				);
	}

	@Override
	public int compareTo(Person o) {
		if(o == null) {
			//push all nulls at the begining if sorted
			return -1;
		}
		return this.firstName.compareTo(o.firstName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}

	
}
