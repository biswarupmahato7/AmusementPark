package org.snowpark.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class Signup {


	@Id
	@Column(unique=true)
	private String username;
	
	@Column(name="email",unique=true)
	@Nonnull
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	

	public Signup() {
//		super();
		// TODO Auto-generated constructor stub
	}



	public Signup(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
