import java.util.Date;
import java.util.List;

public class Behandlung {

	private Person     arzt;
	private Department department;
	private Person     patient;
	private String []  gründe;
	private Date       termin;

	public Behandlung(Person arzt, Department department, Person patient, String[] gründe, Date termin) {
		this.arzt       = arzt;
		this.department = department;
		this.patient    = patient;
		this.gründe     = gründe;
		this.termin     = termin;
	}

	public Behandlung(Person patient, String [] gründe) {
		this.patient = patient;
		this.gründe  = gründe;
	}

}
