package com.Person;

import com.IPerson;

public abstract class Person implements IPerson {

	private String firstName;
	private String lastName;
	private String address;

	public Person(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName  = lastName;
		this.address   = address;
	}


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

}
