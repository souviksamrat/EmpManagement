package com.nagarro.emp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.emp.model.UserDetails;
import com.nagarro.emp.repo.UserRepo;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public boolean isLogin(int id,String password) {
		Optional<UserDetails> data=userRepo.findById(id);
		UserDetails user=null;
		 if(data.isPresent()) {
			 user=data.get();
			 System.out.println(user);
			 if(user.getUserPassword().equals(password)) {
				 return true;
			 } 
		 }
		return false;
	}

}
