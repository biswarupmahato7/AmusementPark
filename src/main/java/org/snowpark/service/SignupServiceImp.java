package org.snowpark.service;

import java.util.Optional;

import org.snowpark.model.Signup;
import org.snowpark.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SignupServiceImp implements SignupService{

	@Autowired
	private SignupRepository signupRepository;
	
	public SignupServiceImp(SignupRepository signupRepository) {
//		super();
		this.signupRepository = signupRepository;
	}

	public SignupServiceImp() {
//		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Signup addUser(Signup signup) {
		// TODO Auto-generated method stub
		return signupRepository.save(signup);
	}

	@Override
	public Signup getUserById(String username) {
		// TODO Auto-generated method stub
		Optional<Signup> opt=signupRepository.findById(username);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}

	@Override
	public Signup updateSignup(Signup signup) {
		// TODO Auto-generated method stub
		return signupRepository.save(signup);
	}

	@Override
	public Signup deleteSignup(String username) {
		// TODO Auto-generated method stub
		Optional<Signup> sup=signupRepository.findById(username);
		if(sup.isPresent()) {
			signupRepository.deleteById(username);
			return sup.get();
		}else {
			return null;
		}
	}

	@Override
	public boolean usernameAlreadyExists(Signup signup) {
		// TODO Auto-generated method stub
		return signupRepository.existsByUsername(signup.getUsername());
	}
	
	
}
