/**
 * @author Christopher O'Connor
 * @date 21/12/2018
 * @version 0.3.1
 */

package com.Hospital;

import com.Person.Doctor;

public class Department {

	private String name;
	private String fachGebiet;

	private Doctor doctor;

	private Building building;
	private Floor floor;

	public Department(String name, String fachGebiet, Building building, String stockwerkName, int zimmerAnz) {

		this.name       = name;
		this.fachGebiet = fachGebiet;
		this.building   = building;
		this.floor      = new Floor(stockwerkName, zimmerAnz);

	}

	/**
	 * Overloading Constructor.
	 */
	public Department(){

		this("Notfallstation", "ALLES", new Building("HauptGB", ""), "EG", 20);
		this.doctor = new Doctor();

	}

	public String getName() {
		return name;
	}

	public Doctor getDoc() {

		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getBuildingFloor() {
		return String.format("%-10s %-10s", building.getName(), floor.getStockwerkName());
	}

}
