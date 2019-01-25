/**
 * @author Christopher O'Connor
 * @date 21/12/2018
 * @version 0.3.1
 */

package com.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Patient extends Person {

	private LocalDate born;
	private String krankenKasse;

	public Patient(String firstName, String lastName, String address, LocalDate born, String krankenKasse) {
		super(firstName, lastName, address);
		this.born = born;
		this.krankenKasse = krankenKasse;
	}

	/**
	 *
	 * @return All Patient Infos.
	 */
	@Override
	public String getInfo() {
		return  "\n\n\tINFOS :-/>" +
				"\n\t\t/>) FN >  " + getFirstName() +
				"\n\t\t/>) LN >  " + getLastName() +
				"\n\t\t/>) AD >  " + getAddress() +
				"\n\t\t/>) BD >  " + this.born +
				"\n\t\t/>) KK >  " + this.krankenKasse + "\n\n";
	}


	public String toFile() {
		return super.getFirstName() + ", " +
				super.getLastName() + ", " +
				super.getAddress()  + ", " +
				getStringOfDate()   + ", " +
				this.krankenKasse   + "\r\n";
	}

	private String getStringOfDate() {

		return this.born.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

	}

}
