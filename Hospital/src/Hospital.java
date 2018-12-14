import java.util.ArrayList;
import java.util.List;

public class Hospital implements InterfaceHospital{

	private String name;

	private List<Building>   buildingList;
	private List<Person>     patientList;
	private List<Behandlung> behandlungList;


	public Hospital(String name) {

		this.name = name;

		this.buildingList   = new ArrayList<>();
		this.patientList    = new ArrayList<>();
		this.behandlungList = new ArrayList<>();
	}

	public Hospital() {
		this("KSA");
	}

	@Override
	public void addBuilding(Building building) {
		buildingList.add(building);
	}

	@Override
	public void addFloor(Floor floor) {

	}

	@Override
	public void addDepartment(Department department) {

	}

}
