package org.snowpark.service;

import java.util.List;
import java.util.Optional;

import org.snowpark.model.Admin;
import org.snowpark.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);

	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> opt = adminRepository.findById(admin.getAdminId());
		if (opt.isPresent()) {
			adminRepository.save(admin);
			return admin;
		}

		return null;
	}

	@Override
	public Admin deleteAdmin(Long adminId) {
		Optional<Admin> opt = adminRepository.findById(adminId);
		if (opt.isPresent()) {
			Admin admin = opt.get();
			adminRepository.delete(admin);
			return admin;
		}
		return null;
	}


	@Override
	public Admin findById(Long adminId) {
		Optional<Admin> opt = adminRepository.findById(adminId);
		if (opt.isPresent()) {
			Admin admin = opt.get();
			return admin;
		}
		return null;
	}

	@Override
	public Admin validateAdmin(String userName, String password) {
		List<Admin> c1 = adminRepository.findAll();
		for (int i = 0; i < c1.size(); i++) {
			if (c1.get(i).getUserName().equals(userName) && c1.get(i).getPassword().equals(password))
				return c1.get(i);
		}
		return null;
	}

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public boolean usernameAlreadyExists(Admin admin) {
		return adminRepository.existsByUserName(admin.getUserName());
		// TODO Auto-generated method stub
	}

	@Override
	public boolean mobileNumberAlreadyExists(Admin admin) {
		return adminRepository.existsByMobileNumber(admin.getMobileNumber());
		// TODO Auto-generated method stub
	}
	
}
