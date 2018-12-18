package com.Hospital;

import com.Person.Doctor;


public class Department {

	private String name;
	private String fachGebiet;

	private Doctor doctor;

	//private List<Employee>   employeeList   = new ArrayList<>();

	private Building building;
	private Floor floor;

	public Department(String name, String fachGebiet, Building building, String stockwerkName, int zimmerAnz) {

		this.name       = name;
		this.fachGebiet = fachGebiet;
		this.building   = building;
		this.floor      = new Floor(stockwerkName, zimmerAnz);

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
