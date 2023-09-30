package org.snowpark.service;

import java.util.List;

import org.snowpark.model.Admin;

public interface AdminService {
	
	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(Admin admin);

	public Admin deleteAdmin(Long adminId);

	public Admin findById(Long adminId);
	
	public List<Admin> findAll();

	public Admin validateAdmin(String userName, String password);
	
	public boolean usernameAlreadyExists(Admin admin);
	
	public boolean mobileNumberAlreadyExists(Admin admin);
}