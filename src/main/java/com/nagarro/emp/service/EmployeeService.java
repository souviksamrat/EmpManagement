package com.nagarro.emp.service;

import java.util.List;

import com.nagarro.emp.model.EmployeeDetails;
/**
 * 
 * @author souvikpatra
 *
 */
public interface EmployeeService {
	
	public List<EmployeeDetails> getAllEmployee();
	public void saveEmployee(EmployeeDetails employeeDetails);
	
	public void deleteEmployeeById(long id);
}
