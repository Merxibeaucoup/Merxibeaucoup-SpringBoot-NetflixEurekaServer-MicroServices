package com.edgar.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.hrservice.models.Employee;
import com.edgar.hrservice.models.EmployeesList;

/*
 * 
 * HR service gets all the requests from a client 
 * 
 * @RestController: indicates this class is a RESTful web service
 * 
 * REST---->  Representational state Transfer: everything is a resource, they are light weight,
 *  highly scalable and maintainable, commonly used to create API's for web-based Apps.
 * 
 * 
 * @RequestMapping("/hr") : directs clients to HR page
 * 
 * 
 */
 
@RestController
@RequestMapping("/hr")
public class HrResources {
	
	
	
	//Hardcoded dummy List
	List <Employee> employees = Arrays.asList(
			new Employee ("E1","Eddie","Merxi","Tennis"),
			new Employee ("E2","paris","Alba","WeightLifting"),
			new Employee ("E3","Baba","Tunde","PickleBall"),
			new Employee ("E4","Cristo","Lagos","WeightLifting"),
			new Employee ("E5","Nick","Costa","FrontDesk"),
			new Employee ("E6","Mathew","Costa","Soccer")
			
			);
	
	
	/*
	 * 
	 *   returns Employees list objects
	 * 
	 */
	
	@RequestMapping("/employees")
	public EmployeesList getEmployees(){
		
		
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployees(employees);
		
		return employeesList;
	}
	
	
	@RequestMapping("/employees/{Id}")
	public Employee getEmployeeById (@PathVariable("Id")String Id) {
		Employee e = employees.stream()
				.filter(employee -> Id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		return e;
	}
	

}
