package com.nagarro.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.emp.model.EmployeeDetails;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Long> {

}
