package com.Hospital;

import com.Console;
import com.IHospital;
import com.Person.Patient;
import com.Person.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital implements IHospital {

	private HashMap<String, Department> depZuweisung;

	private List<Department> depList        = new ArrayList<>();
	private List<Patient>    patientList    = new ArrayList<>();
	private List<Behandlung> behandlungList = new ArrayList<>();
	private List<Building>   buildingList   = new ArrayList<>();

	private Department defaultDep;


	public Hospital() {

		defaultDep = new Department();
		depList.add(defaultDep);

	}

	public void addBuilding(String name, String address) {

		buildingList.add(new Building(name, address));
		Console.println("\t\t:/-/> Added Building: " + name + ", " + address);
	}

	public Building getBuilding(String name) {

		for (Building b : buildingList)
			if (b.getName().equalsIgnoreCase(name)) return b;

		return null;
	}

	public void addDepartment(String name, String fachGebiet, String bName, String stockwerkName, String zimmerAnz) {

		depList.add(new Department(name, fachGebiet, getBuilding(bName), stockwerkName, Integer.valueOf(zimmerAnz)));
		Console.println("\t\t:/-/> Added Department: " + name + ", " + fachGebiet + ", " + stockwerkName);

	}

	public Department getDepartment(String name) {

		for (Department d : depList)
			if (d.getName().equalsIgnoreCase(name)) return d;

		return null;
	}

	public void addDoc(String depName, String firstName, String lastName, String address, LocalDate date, String fachGebiet) {
//		getDepartment(depName).getEmployeeList().add(new Doctor(firstName, lastName, address, date, fachGebiet));
		getDepartment(depName).setDoctor(new Doctor(firstName, lastName, address, date, fachGebiet));
		Console.println("\t\t:/-/> Added Doctor: " + depName + ", " + firstName + ", " + lastName);
	}

	public Patient getPat(String firstName, String lastName) {

		for (Patient p : patientList)
			if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) return p;

		return null;
	}

	public void addPatient(String firstName, String lastName, String address, LocalDate born, String krankenKasse) {

		if(getPat(firstName, lastName) != null) return;

		patientList.add(new Patient(firstName, lastName, address, born, krankenKasse));

		Console.println("\t\t:/-/> Added Patient: " + firstName + ", " + lastName);

	}

	public void addBehandlung(String firstName, String lastName, String beschwerden, String depName, LocalDate date) {

		Department dep = getDepartment(depName);

		behandlungList.add(new Behandlung(getPat(firstName, lastName), beschwerden, dep, dep.getDoc(), date));

		Console.println("\t\t:/-/> Added Behandlung: " + depName + ", " + firstName + ", " + lastName + ", " + beschwerden);
	}

	public void addBehandlung(Patient p, Department dep, String beschwerden, LocalDate date) {

		behandlungList.add(new Behandlung(p, beschwerden, dep, dep.getDoc(), date));
		Console.println("\t\t:/-/> Added Behandlung: " + dep.getName() + ", " + p.getFirstName() + ", " + p.getLastName() + ", " + beschwerden);
	}

	public void setDepZuweisung(HashMap<String, Department> depZuweisung) {
		this.depZuweisung = depZuweisung;
	}

	public void printPatientBehandlungen(Patient patient) {

		for (Behandlung b : behandlungList) {
			if(b.getPatient().equals(patient)) Console.println(b.getInfo());
		}

	}

	public List<Behandlung> getBehandlungList() {
		return behandlungList;
	}

	public Department getZuweisung(String key) {

		if(depZuweisung.containsKey(key)) {
			return depZuweisung.get(key);
		}

		return defaultDep;
	}

}
