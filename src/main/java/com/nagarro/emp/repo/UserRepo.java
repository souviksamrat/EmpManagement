package com.nagarro.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.emp.model.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

}
