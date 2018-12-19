package com;

import com.DATA.Insert;
import com.Hospital.Behandlung;
import com.Hospital.Hospital;
import com.Person.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	private Hospital ksa;

	public static void main(String[] args) {
			new Main().top();
	}

	private void top() {

		ksa = new Insert().generate();

		Console.printWelcome();




		while(true){

			Console.printMainMenu();

			switch(Console.get()) {

				case "1": menuPatient();     break;
				case "2": registerPatient(); break;
				case "3": departmentBehandlungen(); break;
				case "x": break;

				default: Console.falseInput();


			}

		}

	}


	private void menuPatient() {

		Patient currPatient = ksa.getPat(Console.getSearchInfo("FirstName"), Console.getSearchInfo("LastName "));

		if (currPatient != null) {

			boolean repeat = true;

			while (repeat){

				Console.printPatientMenu(currPatient.getFirstName(), currPatient.getLastName());

				switch (Console.get()) {

					case "1": newBehandlung(currPatient); break;
					case "2": ksa.printPatientBehandlungen(currPatient); break;
					case "3": Console.print(currPatient.getInfo()); break;
					case "x": repeat = false; break;

					default: Console.falseInput();

				}
			}


		} else {
			Console.falseInput();
			// REGISTER?
		}


	}

	private void newBehandlung(Patient p) {

		String beschwerden = Console.getSearchInfo("Beschwerden   ");

		ksa.addBehandlung(p, ksa.getZuweisung(beschwerden), beschwerden, LocalDate.now());

	}

	private void registerPatient() {

		String firstName = Console.getSearchInfo("FirstName   ");
		String lastName  = Console.getSearchInfo("LastName    ");

		if (ksa.getPat(firstName, lastName) != null) {
			Console.println("\t\t :/-/> " + firstName + ", " + lastName + " is Already Registered .../>\n");
			return;
		}

		String    address      = Console.getSearchInfo("Address         ");
		LocalDate bornDate     = Console.getDate      ("Born(DD/MM/YYYY)");
		String    krankenKasse = Console.getSearchInfo("Krankenkasse    ");


		ksa.addPatient(firstName, lastName, address, bornDate, krankenKasse);

	}

	private void departmentBehandlungen() {

		ArrayList<Behandlung> temp = new ArrayList<>(ksa.getBehandlungList());

		Collections.sort(temp);

		Console.println("\n\t\t-/>Ordered By Department:\n");

		for (Behandlung b : temp) {
			Console.println(b.getInfo());
		}

	}


}
