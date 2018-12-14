import java.util.ArrayList;
import java.util.List;

public class Building {

	private String name;
	private String address;
	private List<Floor> floorList;


	public Building(String name, String address, List<Floor> floorList) {
		this.name = name;
		this.address = address;
		this.floorList = floorList;
	}

	public Building(String name, String address) {
		this(name, address, new ArrayList<>());
	}

}
