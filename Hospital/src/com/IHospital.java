package com;

import com.Hospital.Department;
import com.Person.Patient;

import java.time.LocalDate;
import java.util.HashMap;

public interface IHospital {

	void addBuilding(String name, String address);

	void addDepartment(String name, String fachGebiet, String bName, String stockwerkName, String zimmerAnz);

	void addDoc(String depName, String firstName, String lastName, String address, LocalDate date, String fachGebiet);

	void addPatient(String firstName, String lastName, String address, LocalDate born, String krankenKasse);

	void addBehandlung(String firstName, String lastName, String beschwerden, String depName, LocalDate date);

	void setDepZuweisung(HashMap<String, Department> depZuweisung);

	void printPatientBehandlungen(Patient patient);

}
