package com.nagarro.emp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
	@Id
	private int userId;
	private String userPassword;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserDetails() {
	}
	public UserDetails(int userId, String userPassword) {
		
		this.userId = userId;
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userPassword=" + userPassword + "]";
	}
	
}
