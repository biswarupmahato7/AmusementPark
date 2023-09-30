package org.snowpark.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
	
	private String userName;
	private String password;
//	private String address;
	private String mobileNumber;
	private String emailId;
	
	
	public User() {
		super();
	}
	
	public User(String userName, String password,String mobileNumber, String emailId) {
		super();
		this.userName = userName;
		this.mobileNumber=mobileNumber;
		this.password= password;
		this.emailId = emailId;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
//
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
