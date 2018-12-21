/**
 * @author Christopher O'Connor
 * @date 21/12/2018
 * @version 0.3.1
 */

package com.Person;

import java.time.LocalDate;

public class Doctor extends Employee {

	private String fachGebiet;

	public Doctor(String firstName, String lastName, String address, LocalDate angestelltSeit, String fachGebiet) {
		super(firstName, lastName, address, angestelltSeit);
		this.fachGebiet = fachGebiet;
	}

	public Doctor() {
		super("Ambulant", "Ambluant", "HauptGB", null);
		this.fachGebiet = "Notfall";
	}

	public void printD() {
		System.out.println(this.getFirstName() + " " + this.getLastName());
	}

	@Override
	public String getInfo() {
		return super.getInfo();
	}

}
