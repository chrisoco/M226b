/**
 * @author Christopher O'Connor
 * @date 21/12/2018
 * @version 0.3.1
 */

package com.DATA;

import com.Hospital.Department;
import com.Hospital.Hospital;
import com.InsertData;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class Insert implements InsertData {

	private static Hospital  h;
	private static Scanner   sc;
	private static String    line;
	private static String [] lineArr;


	public Insert() {
		h = new Hospital();
	}

	public Hospital generate() {

		try {

			insertBuildings();
			insertDepartments();
			insertEmployee();
			insertPatient();
			insertBehandlung();
			h.setDepZuweisung(insertHashMapData());

		} catch (Exception e){}

		return h;
	}

	public void insertBuildings() throws FileNotFoundException {

		sc = new Scanner(new File("src/com/DATA/Buildings.txt"));

		while(sc.hasNextLine()) {

			line = sc.nextLine();
			lineArr = line.split(", ");

			h.addBuilding(lineArr[0], lineArr[1]);
		}

	}

	public void insertDepartments() throws FileNotFoundException {

		sc = new Scanner(new File("src/com/DATA/Departments.txt"));

		while(sc.hasNextLine()) {

			line = sc.nextLine();
			lineArr = line.split(", ");

			h.addDepartment(lineArr[0], lineArr[1], lineArr[2], lineArr[3], lineArr[4]);

		}

	}

	private static LocalDate getDateOfString(String date) {

		return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}

	public void insertEmployee() throws FileNotFoundException {

		sc = new Scanner(new File("src/com/DATA/Employee.txt"));

		while(sc.hasNextLine()) {

			line = sc.nextLine();
			lineArr = line.split(", ");

			h.addDoc(lineArr[0], lineArr[1], lineArr[2], lineArr[3], getDateOfString(lineArr[4]), lineArr[5]);

		}

	}

	public void insertPatient() throws FileNotFoundException {

		sc = new Scanner(new File("src/com/DATA/Patients.txt"));

		while(sc.hasNextLine()) {

			line = sc.nextLine();
			lineArr = line.split(", ");

			h.addPatient(lineArr[0], lineArr[1], lineArr[2], getDateOfString(lineArr[3]), lineArr[4]);

		}

	}

	public void insertBehandlung() throws FileNotFoundException {

		sc = new Scanner(new File("src/com/DATA/Behandlungen.txt"));

		while(sc.hasNextLine()) {

			line = sc.nextLine();
			lineArr = line.split(", ");

			h.addBehandlung(lineArr[0], lineArr[1], lineArr[2], lineArr[3], getDateOfString(lineArr[4]));

		}

	}

	public HashMap<String, Department> insertHashMapData() throws FileNotFoundException {

		HashMap<String, Department> hashMap = new HashMap<>();

		sc = new Scanner(new File("src/com/DATA/HMap.txt"));

		while(sc.hasNextLine()) {

			line = sc.nextLine();
			lineArr = line.split(", ");

			hashMap.put(lineArr[0], h.getDepartment(lineArr[1]));

		}

		return hashMap;
	}

}
