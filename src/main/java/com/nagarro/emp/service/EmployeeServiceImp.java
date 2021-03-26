package com.nagarro.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.emp.constant.Constant;
import com.nagarro.emp.model.EmployeeDetails;
import com.nagarro.emp.repo.EmployeeRepo;
/**
 * 
 * @author souvikpatra
 *
 */

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	public Constant constant;
	
	// Rest api template
	public RestTemplate restTemplate =new RestTemplate();
	
	/**
	 *  for getting the all employee details
	 */
	@Override
	public List<EmployeeDetails> getAllEmployee() {
		List<EmployeeDetails> employees;
		String url = Constant.REST_URL + Constant.GET_ALL_EMPLOYEES;
		ResponseEntity<List<EmployeeDetails>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmployeeDetails>>() {
				});
		employees = response.getBody();
		return employees;
	}

	/**
	 *  for save the employee
	 */
	@Override
	public void saveEmployee(EmployeeDetails employeeDetails) {
		String url = Constant.REST_URL + Constant.POST_EMPLOYEE;
		restTemplate.postForObject(url, employeeDetails, EmployeeDetails.class);

	}


	/**
	 *  for delete the employee
	 */
	@Override
	public void deleteEmployeeById(long id) {
		
		this.empRepo.deleteById(id);
	}
	
	/**
	 *  
	 * @param id employee id
	 * @return return the only one particular employee details
	 */
	public EmployeeDetails getEmployeeById(long id){
		Optional<EmployeeDetails> employeeDetails=this.empRepo.findById(id);
		EmployeeDetails data=null;
		if(employeeDetails.isPresent()) {
			data=employeeDetails.get();
		}
		return  data;
	}

}
