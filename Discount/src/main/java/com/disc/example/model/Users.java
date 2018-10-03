package com.disc.example.model;

import org.springframework.stereotype.Service;

@Service
public class Users 
{
   private String userType;
   private int userAmount;
   
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public int getUserAmount() {
	return userAmount;
}
public void setUserAmount(int userAmount) {
	this.userAmount = userAmount;
}
   
}
