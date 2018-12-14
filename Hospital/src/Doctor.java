public class Doctor extends Person {

	private String fachgebiet;


	public Doctor(String vorname, String nachname, String fachgebiet) {
		super(vorname, nachname);
		this.fachgebiet = fachgebiet;
	}

}
