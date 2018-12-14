import java.util.Date;

public class Patient extends Person{

	private Date geb;
	private String krankenkasse;

	public Patient(String vorname, String nachname, Date geb, String krankenkasse) {
		super(vorname, nachname);
		this.geb = geb;
		this.krankenkasse = krankenkasse;
	}

}
