package com.Person;

import java.time.LocalDate;

public abstract class Employee extends Person {

	private LocalDate angestelltSeit;

	public Employee(String firstName, String lastName, String address, LocalDate angestelltSeit) {
		super(firstName, lastName, address);
		this.angestelltSeit = angestelltSeit;
	}


}
