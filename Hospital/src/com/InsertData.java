package com;

import com.Hospital.Department;
import com.Hospital.Hospital;
import java.util.HashMap;

public interface InsertData {

	Hospital generate();

	void insertBuildings   () throws Exception;
	void insertDepartments () throws Exception;
	void insertEmployee    () throws Exception;
	void insertPatient     () throws Exception;
	void insertBehandlung  () throws Exception;

	HashMap<String, Department> insertHashMapData() throws Exception;


}
