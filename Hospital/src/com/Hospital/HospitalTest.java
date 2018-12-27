package com.Hospital;

import com.DATA.Insert;
import com.Person.Patient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {

	static Hospital ksa;
	static Patient p;

	@BeforeAll
	public static void setUp() {

		ksa = new Insert().generate();
		  p = new Patient("TestPat", "TestPat", "TTP 01", LocalDate.now(), "TCS");

	}

	@Test
	void Building() {

		ksa.addBuilding("TestBuilding", "TestStreet 01");

		assertNotNull(ksa.getBuilding("TestBuilding"));

	}

	@Test
	void Department() {

		ksa.addDepartment("TEST", "TEST", "B1", "OG", "3");

		assertNotNull(ksa.getDepartment("TEST"));

	}

	@Test
	void Doc() {

		ksa.addDoc("TEST", "TestDOC", "TestDOC", "TTstr. 01", LocalDate.now(), "TESTING");

		assertEquals(ksa.getDepartment("TEST").getDoc().getFirstName(), "TestDOC");

		}

	@Test
	void Patient() {

		ksa.addPatient(p.getFirstName(), p.getLastName(), p.getAddress(), LocalDate.now(), "TCS");

		assertNotNull(ksa.getPat("TestPat", "TestPat"));

	}

	@Test
	void Behandlung() {

		int behandlungSize = ksa.getBehandlungList().size();

		ksa.addBehandlung(p.getFirstName(), p.getLastName(), "Herz", "Kardiologie", LocalDate.now());
		ksa.addBehandlung(p, ksa.getDepartment("Physiotherapie"), "Kraft", LocalDate.now());

		assertTrue(behandlungSize == ksa.getBehandlungList().size() - 2);

	}

}