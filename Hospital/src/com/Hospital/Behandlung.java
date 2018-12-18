package com.Hospital;

import com.Person.Doctor;
import com.Person.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Behandlung implements Comparable<Behandlung>{

	private Patient patient;
	private String  beschwerden;

	private Department department;
	private Doctor     doctor;

	private LocalDate termin;

	public Behandlung(Patient patient, String beschwerden, Department department, Doctor doctor, LocalDate termin) {

		this.patient     = patient;
		this.beschwerden = beschwerden;

		this.department  = department;
		this.doctor      = doctor;

		this.termin      = termin;

	}

	@Override
	public int compareTo(Behandlung o) {
		return this.department.getName().compareTo(o.getDepartment().getName());
	}

	public String getInfo() {

		String docName = "";

		if (doctor != null) this.doctor.getLastName();

		return String.format("\t\t-/> %-20s DR. %-20s %s %-14s %-20s %s", department.getName(), docName, department.getBuildingFloor(), formatDateOfCal(termin), patient.getLastName(), beschwerden);
	}


	private String formatDateOfCal(LocalDate date) {

		return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}

	public Patient getPatient() {
		return patient;
	}

	public Department getDepartment() {
		return department;
	}

}
