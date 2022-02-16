package com.edgar.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.pathologyservice.models.Department;
import com.edgar.pathologyservice.models.DepartmentList;

@RestController
@RequestMapping("/department")
public class PathologyResource {

	List<Department> departments = Arrays.asList(new Department("D1", "Hit", "warm bath"),
			new Department("D2", "Malaria", "chloroquine"));

	@RequestMapping("/speci")
	public DepartmentList getDepartments() {
		
		DepartmentList  dList = new DepartmentList();
		dList.setDepartment(departments);
		
		
		return dList;
	}

	@RequestMapping("/specialty/{Id}")
	public Department getDepartmentById(@PathVariable("Id") String Id) {

		Department d = departments.stream().filter(department -> Id.equals(department.getId())).findAny().orElse(null);
		return d;

	}

}
