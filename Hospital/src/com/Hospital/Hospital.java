/**
 * @author Christopher O'Connor
 * @date 21/12/2018
 * @version 0.3.1
 */

package com.Hospital;

import com.Console;
import com.Person.Doctor;
import com.Person.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {

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

	/**
	 * Add new Building to buildingList
	 * @param name String Name of Building
	 * @param address String Address of Building
	 */
	public void addBuilding(String name, String address) {

		buildingList.add(new Building(name, address));
		Console.println("\t\t:/-/> Added Building: " + name + ", " + address);
	}

	/**
	 * Get Building from buildingList with entered Name.
	 * @param name String Name to Compare all Objects.names too
	 * @return Building with Matching name.
	 */
	public Building getBuilding(String name) {

		for (Building b : buildingList)
			if (b.getName().equalsIgnoreCase(name)) return b;

		return null;
	}

	/**
	 * Add new Department to depList
	 * @param name Name of Department
	 * @param fachGebiet String
	 * @param bName String of Building name.
	 * @param stockwerkName String
	 * @param zimmerAnz String
	 */
	public void addDepartment(String name, String fachGebiet, String bName, String stockwerkName, String zimmerAnz) {

		depList.add(new Department(name, fachGebiet, getBuilding(bName), stockwerkName, Integer.valueOf(zimmerAnz)));
		Console.println("\t\t:/-/> Added Department: " + name + ", " + fachGebiet + ", " + stockwerkName);

	}

	/**
	 * Get Department from depList with entered Name.
	 * @param name String Name to Compare all Objects.name too
	 * @return Department with Matching name.
	 */
	public Department getDepartment(String name) {

		for (Department d : depList)
			if (d.getName().equalsIgnoreCase(name)) return d;

		return null;
	}

	/**
	 * Add new Doctor to Department
	 * @param depName String Department Name.
	 * @param firstName String
	 * @param lastName String
	 * @param address String
	 * @param date LocalDate
	 * @param fachGebiet String
	 */
	public void addDoc(String depName, String firstName, String lastName, String address, LocalDate date, String fachGebiet) {
//		getDepartment(depName).getEmployeeList().add(new Doctor(firstName, lastName, address, date, fachGebiet));
		getDepartment(depName).setDoctor(new Doctor(firstName, lastName, address, date, fachGebiet));
		Console.println("\t\t:/-/> Added Doctor: " + depName + ", " + firstName + ", " + lastName);
	}

	/**
	 * Get Patient from patientList with matching First & LastName.
	 * @param firstName String searchString 1
	 * @param lastName String searchString 2
	 * @return Patient with Matching First & LastName.
	 */
	public Patient getPat(String firstName, String lastName) {

		for (Patient p : patientList)
			if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) return p;

		return null;
	}

	/**
	 * Add new Patient to PatientList
	 * @param firstName String
	 * @param lastName String
	 * @param address String
	 * @param born LocalDate
	 * @param krankenKasse String
	 */
	public void addPatient(String firstName, String lastName, String address, LocalDate born, String krankenKasse) {

		if(getPat(firstName, lastName) != null) return;

		patientList.add(new Patient(firstName, lastName, address, born, krankenKasse));

		Console.println("\t\t:/-/> Added Patient: " + firstName + ", " + lastName);

	}

	/**
	 * Add new Behandlung to BehandlungList
	 * @param firstName String
	 * @param lastName String
	 * @param beschwerden String
	 * @param depName String
	 * @param date LocalDate (BehandlungsDate)
	 */
	public void addBehandlung(String firstName, String lastName, String beschwerden, String depName, LocalDate date) {

		Department dep = getDepartment(depName);

		behandlungList.add(new Behandlung(getPat(firstName, lastName), beschwerden, dep, dep.getDoc(), date));

		Console.println("\t\t:/-/> Added Behandlung: " + depName + ", " + firstName + ", " + lastName + ", " + beschwerden);
	}

	/**
	 * Add new Behandlung to BehandlungList (Overload)
	 * @param p Patient
	 * @param dep Department
	 * @param beschwerden String
	 * @param date LocalDate
	 */
	public void addBehandlung(Patient p, Department dep, String beschwerden, LocalDate date) {

		behandlungList.add(new Behandlung(p, beschwerden, dep, dep.getDoc(), date));
		Console.println("\t\t:/-/> Added Behandlung: " + dep.getName() + ", " + p.getFirstName() + ", " + p.getLastName() + ", " + beschwerden);
	}

	public void setDepZuweisung(HashMap<String, Department> depZuweisung) {
		this.depZuweisung = depZuweisung;
	}

	/**
	 * Print all Behandlungen From Patient.
	 * @param patient Patient
	 */
	public void printPatientBehandlungen(Patient patient) {

		for (Behandlung b : behandlungList) {
			if(b.getPatient().equals(patient)) Console.println(b.getInfo());
		}

	}

	public List<Behandlung> getBehandlungList() {
		return behandlungList;
	}

	/**
	 * Get Department matching searchKey of the HashMap.
	 * @param key String Key
	 * @return Department matching Key.
	 */
	public Department getZuweisung(String key) {

		if(depZuweisung.containsKey(key)) {
			return depZuweisung.get(key);
		}

		return defaultDep;
	}

	public List<Building> getBuildingList() {
		return buildingList;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

}
