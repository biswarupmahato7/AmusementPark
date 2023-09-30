package org.snowpark.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table(name="Login")
@Component
@Scope("session")
public class Login {
	
//	@Id
//	@Column
	private String Username;
	
	@Column
	private String Password;
	

	public Login() {
//		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String username, String password) {
//		super();
		Username = username;
		Password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	

}
