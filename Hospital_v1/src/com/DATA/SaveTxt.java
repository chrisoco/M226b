package com.DATA;

import com.Hospital.Behandlung;
import com.Hospital.Hospital;
import com.Person.Patient;

import java.io.FileWriter;

public class SaveTxt {

	private Hospital hospital;

	public SaveTxt(Hospital hospital) {
		this.hospital = hospital;
		savePatient();
		saveBehandlungen();
	}

	private void savePatient() {

		try (FileWriter fw = new FileWriter("src/com/DATA/Patients.txt")) {


			for (Patient p : hospital.getPatientList()) {

				fw.write(p.toFile());

			}

			System.out.println("\t\t\t:/-/> Successfully Saved Patients.");

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	private void saveBehandlungen() {

		try (FileWriter fw = new FileWriter("src/com/DATA/Behandlungen.txt")) {

			for(Behandlung b : hospital.getBehandlungList()) {

				fw.write(b.toFile());

			}

			System.out.println("\t\t\t:/-/> Successfully Saved Behandlungen.");

		} catch (Exception e) {

			System.out.println(e);

		}

	}



}
