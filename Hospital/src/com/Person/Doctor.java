package com.Person;

import java.time.LocalDate;

public class Doctor extends Employee {

	private String fachGebiet;

	public Doctor(String firstName, String lastName, String address, LocalDate angestelltSeit, String fachGebiet) {
		super(firstName, lastName, address, angestelltSeit);
		this.fachGebiet = fachGebiet;
	}

	public void printD() {
		System.out.println(this.getFirstName() + " " + this.getLastName());
	}

}
