package org.snowpark.service;

import org.snowpark.model.Signup;

//import javax.management.MXBean;

import org.springframework.stereotype.Service;

//import com.Customer.model.Signup;


//import org.springframework.stereotype.Service;

//import com.Customer.model.Signup;


@Service
public interface SignupService {
	public Signup addUser(Signup signup);
	public Signup getUserById(String username);
	public Signup updateSignup(Signup signup);
	public Signup deleteSignup(String username);
	public boolean usernameAlreadyExists(Signup signup);
//	public Signup getUserByUsername(String username);
//	public Signup deleteByUsername(String Username);
}
