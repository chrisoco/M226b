package com.Person;

import java.time.LocalDate;

public abstract class Employee extends Person {

	private LocalDate angestelltSeit;

	public Employee(String firstName, String lastName, String address, LocalDate angestelltSeit) {
		super(firstName, lastName, address);
		this.angestelltSeit = angestelltSeit;
	}

	@Override
	public String getInfo() {
		return "\n\n\tINFOS :-/>" +
				"\n\t\t/>) FN >  " + getFirstName() +
				"\n\t\t/>) LN >  " + getLastName() +
				"\n\t\t/>) AD >  " + getAddress() + "\n\n";
	}

}
