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


}
