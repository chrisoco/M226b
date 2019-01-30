/**
 * @author Christopher O'Connor
 * @date 21/12/2018
 * @version 0.3.1
 */

package com;

import com.DATA.Insert;
import com.DATA.SaveTxt;
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

		boolean exit = false;

		while(!exit){

			Console.printMainMenu();

			switch(Console.get()) {

				case "1": menuPatient();            break;
				case "2": registerPatient();        break;
				case "3": departmentBehandlungen(); break;
				case "4": new SaveTxt(ksa);         break;
				case "X":
				case "x": exit = Console.bye();     break;

				default: Console.falseInput();

			}

		}

	}

	/**
	 * Menu of selected Patient.
	 *
	 */
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

	/**
	 * Add a new Behandlung to Patient
	 * @param p selected Patient
	 */
	private void newBehandlung(Patient p) {

		String beschwerden = Console.getSearchInfo("Beschwerden   ");

		ksa.addBehandlung(p, ksa.getZuweisung(beschwerden), beschwerden, LocalDate.now());

	}

	/**
	 * Register a new Patient
	 */
	private void registerPatient() {

		String firstName = Console.getSearchInfo("FirstName   ");
		String lastName  = Console.getSearchInfo("LastName    ");

		if (ksa.getPat(firstName, lastName) != null) {
			Console.println("\t\t :/-/> " + firstName + ", " + lastName + " is Already Registered .../>\n");
			return;
		}

		String    address      = Console.getSearchInfo("Address         ");
		LocalDate bornDate     = Console.getDate      ();
		String    krankenKasse = Console.getSearchInfo("Krankenkasse    ");


		ksa.addPatient(firstName, lastName, address, bornDate, krankenKasse);

	}

	/**
	 * Print all Behandlungen grouped by Department.
	 */
	private void departmentBehandlungen() {

		ArrayList<Behandlung> temp = new ArrayList<>(ksa.getBehandlungList());

		Collections.sort(temp);

		Console.println("\n\t\t-/>Ordered By Department:\n");

		for (Behandlung b : temp) {
			Console.println(b.getInfo());
		}

	}


}
