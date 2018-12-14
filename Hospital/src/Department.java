import java.util.ArrayList;
import java.util.List;

public class Department {

	private String name;
	private String gebiet;
	private List<Person> angestellte;
	private List<Behandlung> behandlungList;

	public Department(String name, String gebiet) {
		this.name   = name;
		this.gebiet = gebiet;

		this.angestellte    = new ArrayList<>();
		this.behandlungList = new ArrayList<>();
	}

}
