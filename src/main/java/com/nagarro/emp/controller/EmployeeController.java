package com.nagarro.emp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nagarro.emp.model.EmployeeDetails;
import com.nagarro.emp.service.EmployeeServiceImp;
/**
 * 
 * @author souvikpatra
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeServiceImp empService;
	
	/**
	 *   For fetching all employee
	 * @param model
	 * @return
	 */
	@GetMapping("/allEmp")
	public String showAllEmployee(Model model) {
		System.out.println("Employee Page");
		List<EmployeeDetails> empData=this.empService.getAllEmployee();
		System.out.println(empData);
		model.addAttribute("allEmpData",empData);
		return "all_employee";
	}
		
	
	/**
	 *  for adding new employee form showing
	 * @param Model
	 * @return
	 */
	@GetMapping("/showFormNewEmployee")
	public String newEmployeeForm(Model Model) {
		System.out.println("new employee");
		return "add_new_employee";
	}
	
	/**
	 *  for save employee
	 * @param empdata
	 * @return
	 */
	@PostMapping("/saveEmployee")
	public String  saveEmployee(@ModelAttribute("empdata") EmployeeDetails empdata ) {
		System.out.println("saved");
		this.empService.saveEmployee(empdata);
		return "redirect:/allEmp";
	}
	
	/**
	 * controller for delete employee
	 * @param empId
	 * @return
	 */
	@GetMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable("empId") int empId) {
		this.empService.deleteEmployeeById(empId);
		System.out.println("deleted");
		return "redirect:/allEmp";
	}
	
	/**
	 *  for showing updated form 
	 * @param empId
	 * @param model
	 * @return
	 */
	@GetMapping("/showFormForUpdate/{empId}")
	public String updateEmployeeForm(@PathVariable("empId") long empId,Model model) {
		EmployeeDetails employeeDetails= this.empService.getEmployeeById(empId);
		System.out.println(employeeDetails);
		model.addAttribute("empdetails",employeeDetails);
		System.out.println("updated method");
		return "update_employee";
		
		
	}
	
}
