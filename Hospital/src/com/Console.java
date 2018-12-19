package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Console {

	static Scanner sc = new Scanner(System.in);

	public static void println(String s) {
		System.out.println(s);
	}

	public static void print(String s) {
		System.out.print(s);
	}

	public static void printWelcome() {

		println("\nWELCOME To our Hospital KSA />\n");

	}

	public static void printMainMenu() {

		println(  "\n\t1)> Look UP Patient" +
				  "\n\t2)> Register\n" +
				  "\n\t3)> List Behandlungen <DEP>\n" +
				  "\n\tx)> Exit\n");
	}

	public static String get() {
		System.out.print("\n\t :/-/>  ");

		return sc.nextLine().trim();
	}

	public static void falseInput() {

		println( "\n\t)> False Input Entered...\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}

	}

	public static String getSearchInfo(String info) {

		print("\n\t ) Enter " + info + " /> ");

		return sc.nextLine().trim();

	}

	public static void printPatientMenu(String firstName, String lastName) {

		println(  "\n\t\tSelected Patient :" +
				"\n\t\t\t@ " + firstName + " " + lastName);


		println(  "\n\t1)> NEW  Behandlung" +
				  "\n\t2)> LIST Behandlungen" +
				  "\n\t3)> LIST INFOS" +
				  "\n\tx)> RETURN\n");

	}

	public static LocalDate getDate(String info) {

		return LocalDate.parse(getSearchInfo(info), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

}
