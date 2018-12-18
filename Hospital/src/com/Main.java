package com;

import com.DATA.Insert;
import com.Hospital.Behandlung;
import com.Hospital.Hospital;
import com.Person.Patient;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	Hospital ksa;

	public static void main(String[] args) {
		try {
			new Main().top();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void top() throws FileNotFoundException {

		ksa = Insert.generate("Kanton Spital Aarau");

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

		Patient currPatient = ksa.getPat(Console.getSearchInfo("FirstName"), Console.getSearchInfo("LastName"));

		if (currPatient != null) {

			boolean repeat = true;

			while (repeat){

				Console.printPatientMenu(currPatient.getFirstName(), currPatient.getLastName());

				switch (Console.get()) {

					case "1": /* NEW BEHANDLUNG */break;
					case "2": ksa.printPatientBehandlungen(currPatient); break;
					case "x": repeat = false; break;

					default: Console.falseInput();

				}
			}


		} else {
			Console.falseInput();
			// REGISTER?
		}


	}

	private void registerPatient() {

	}


	private void departmentBehandlungen() {

		ArrayList<Behandlung> temp = new ArrayList<>(ksa.getBehandlungList());

		Collections.sort(temp);

		Console.print("\n\t\t-/>Ordered By Department:\n");

		for (Behandlung b : temp) {
			Console.print(b.getInfo());
		}

	}



}
