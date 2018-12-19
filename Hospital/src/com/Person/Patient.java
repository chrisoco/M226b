package com.Person;

import java.time.LocalDate;

public class Patient extends Person {

	private LocalDate born;
	private String krankenKasse;

	public Patient(String firstName, String lastName, String address, LocalDate born, String krankenKasse) {
		super(firstName, lastName, address);
		this.born = born;
		this.krankenKasse = krankenKasse;
	}

	@Override
	public String getInfo() {
		return  "\n\n\tINFOS :-/>" +
				"\n\t\t/>) FN >  " + getFirstName() +
				"\n\t\t/>) LN >  " + getLastName() +
				"\n\t\t/>) AD >  " + getAddress() +
				"\n\t\t/>) BD >  " + this.born +
				"\n\t\t/>) KK >  " + this.krankenKasse + "\n\n";
	}

}
