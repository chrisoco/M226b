package com.Hospital;

import com.Console;
import com.Person.Doctor;
import com.Person.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {

	private String name;

	private HashMap<String, Department> depZuweisung;

	private List<Department> depList        = new ArrayList<>();
	private List<Patient>    patientList    = new ArrayList<>();
	private List<Behandlung> behandlungList = new ArrayList<>();
	private List<Building>   buildingList   = new ArrayList<>();


	public Hospital(String name) {
		this.name = name;
	}

	public void addBuilding(String name, String address) {

		buildingList.add(new Building(name, address));
	}

	public Building getBuilding(String name) {

		for (Building b : buildingList)
			if (b.getName().equalsIgnoreCase(name)) return b;

		return null;
	}

	public void addDepartment(String name, String fachGebiet, String bName, String stockwerkName, String zimmerAnz) {

		depList.add(new Department(name, fachGebiet, getBuilding(bName), stockwerkName, Integer.valueOf(zimmerAnz)));

	}

	public Department getDepartment(String name) {

		for (Department d : depList)
			if (d.getName().equalsIgnoreCase(name)) return d;

		return null;
	}

	public void addDoc(String depName, String firstName, String lastName, String address, LocalDate date, String fachGebiet) {
//		getDepartment(depName).getEmployeeList().add(new Doctor(firstName, lastName, address, date, fachGebiet));
		getDepartment(depName).setDoctor(new Doctor(firstName, lastName, address, date, fachGebiet));
	}

	public Patient getPat(String firstName, String lastName) {

		for (Patient p : patientList)
			if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) return p;

		return null;
	}

	public void addPatient(String firstName, String lastName, String address, LocalDate born, String krankenKasse) {

		patientList.add(new Patient(firstName, lastName, address, born, krankenKasse));
	}

	public void addBehandlung(String firstName, String lastName, String beschwerden, String depName, LocalDate date) {

		Department dep = getDepartment(depName);

		behandlungList.add(new Behandlung(getPat(firstName, lastName), beschwerden, dep, dep.getDoc(), date));
	}

	public void setDepZuweisung(HashMap<String, Department> depZuweisung) {
		this.depZuweisung = depZuweisung;
	}

	public void printPatientBehandlungen(Patient patient) {

		for (Behandlung b : behandlungList) {
			if(b.getPatient().equals(patient)) Console.print(b.getInfo());
		}

	}

	public List<Behandlung> getBehandlungList() {
		return behandlungList;
	}

}
