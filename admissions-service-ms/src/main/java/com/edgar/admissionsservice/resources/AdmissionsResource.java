package com.edgar.admissionsservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edgar.admissionsservice.models.DepartmentList;
import com.edgar.admissionsservice.models.EmployeesList;
import com.edgar.admissionsservice.models.Member;


/*
 * 
 * @RestController  : handles rest services requests coming from the clients 
 * 
 * @RequestMapping("/admissions") : gets the admissions page
 * 
 */

@RestController  //handles rest services requests coming from the clients 
@RequestMapping("/admissions")
public class AdmissionsResource {
	
	
	
	@Autowired
	private  RestTemplate restTemplate;
	
	
	List<Member> members = Arrays.asList(
			new Member("P1","Gabor","male",30),
			new Member("P2","Eddie","male",22),
			new Member("P3","Elaine","Female",18),
			new Member("P3","Kathy","Female", 46),
			new Member("P3","Bill","Male",42)
			
			);
			
	
	
	
	/*
	 * 
	 * returns a list of patients
	 * 
	 * @RequestMapping("/patients") : gets the patients page
	 * 
	 */
	@RequestMapping("/members")
	public List<Member> getMembers(){
		
		
		return members;
	}
	
	
	/*
	 * takes an Id and returns a single Patient
	 * 
	 *  @PathVariable("Id") : used to extract the value from the URI
	 *  
	 *  @RequestMapping("/patients/{Id}"): returns a patient with the specific Id
	 *  
	 *  Patient object p uses a stream to find id and filters it
	 *   such that , if Id is available it returns it , else it returns null 
	 * 
	 */
	
	@RequestMapping("/members/{Id}")
	public Member getPatientId( @PathVariable("Id")String Id) {
		
		Member p = members.stream()
				.filter(patients -> Id.equals(patients.getId()))
				.findAny()
				.orElse(null);
		
		return p;
		
		
	}
	
	
	/*
	 * 
	 * gets employees list from HR service
	 * 
	 * 
	 * Uses restTemplate to get Employees List from HR 
	 * 
	 *  copy and paste employee and emploeelist classes from HR class to admissions .models package then import it in here 
	 * 
	 */
	
	@RequestMapping("/coaches")
		public EmployeesList getCoaches() {
		
		EmployeesList employeeslist =restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
		
		return employeeslist;
		
	}
	
	@RequestMapping("/specialty")
	public DepartmentList getSpecialties() {
		DepartmentList departmentList = restTemplate.getForObject("http://pathology-service/department/specialty", DepartmentList.class);
		
		return departmentList;
		
	}

}
