package com.nagarro.emp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDetails {
	@Id
	private long employeeCode;
	private String employeeName;
	private String employeeLocation;
	private String employeeEmail;
	private String employeeDateOfBirth;
	public EmployeeDetails() { 
	}
	public long getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(long employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}
	public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}
	public EmployeeDetails(long employeeCode, String employeeName, String employeeLocation, String employeeEmail,
			String employeeDateOfBirth) {
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.employeeLocation = employeeLocation;
		this.employeeEmail = employeeEmail;
		this.employeeDateOfBirth = employeeDateOfBirth;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [employeeCode=" + employeeCode + ", employeeName=" + employeeName
				+ ", employeeLocation=" + employeeLocation + ", employeeEmail=" + employeeEmail
				+ ", employeeDateOfBirth=" + employeeDateOfBirth + "]";
	}
	
	
	
	
	
}
