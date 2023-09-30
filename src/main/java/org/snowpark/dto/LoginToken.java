package org.snowpark.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("loginToken")
@Scope("session")
public class LoginToken {
	
	private String username;
	private String password;
	
	public LoginToken() {
		
	}

	public LoginToken(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	@Override
	public String toString() {
		return "LoginToken [username=" + username + ", password=" + password + "]";
	}
	
	

}
