package com.addressbook.main;

public class Person {
	private String name, lastname;
	private int age;
	private Address address;

	public Person(String name, String lastname, Address address, int age) {
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean equals(Person person) {
		if (name.equals(person.name) && lastname.equals(person.lastname) && age==person.age)
			return true;
		return false;
	}
	

//	 public String toString() {
//	 return name+","+lastname+","address+","+number+",";
//	 }
}