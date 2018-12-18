package com;

import java.util.Scanner;

public class Console {

	static Scanner sc = new Scanner(System.in);

	public static void print(String s) {
		System.out.println(s);
	}

	public static void printWelcome() {

		print("\nWELCOME To our Hospital KSA />\n");

	}

	public static void printMainMenu() {

		print(  "\n\t1)> Look UP Patient" +
				"\n\t2)> Register\n" +
				"\n\t3)> List Behandlungen <DEP>\n" +
				"\n\tx)> Exit\n");
	}

	public static String get() {
		System.out.print("\t :/-/>  ");

		return sc.nextLine().trim();
	}

	public static void falseInput() {

		print( "\n\t)> False Input Entered...\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}

	}

	public static String getSearchInfo(String info) {

		print("\n\t ) Enter " + info + " />");

		return get();

	}

	public static void printPatientMenu(String firstName, String lastName) {

		print(  "\n\t\tYour Search has Been Succesfull!" +
				"\n\t\t\t@ " + firstName + " " + lastName);


		print(  "\n\t1)> NEW  Behandlung" +
				"\n\t2)> LIST Behandlungen\n" +
				"\n\tx)> RETURN\n");

	}

}
