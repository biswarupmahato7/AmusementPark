package org.snowpark;

import org.snowpark.model.Signup;
import org.snowpark.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//import com.Customer.model.Signup;
import org.snowpark.model.Login;
//import com.Customer.service.SignupService;

@Controller
//@RequestMapping("/login")
public class SignupController {
	@Autowired
	private SignupService signupService;
	@GetMapping("/login")
	public String Login(Model model){
//		String up[]=new String[2];
//		String Username=new String();
//		String Password=new String();
//		model.addAttribute("Username", Username);
//		model.addAttribute("Password", Password);
//		model.addAttribute("up",up);
		Login login=new Login();
		model.addAttribute("login", login);
		return "User/login";
		
	}
	
	@PostMapping("/login")
	public String LoginProcess(@ModelAttribute("Username")String Username,@ModelAttribute("Password")String Password,Model model ) {
		if(signupService.getUserById(Username)!=null) {
			Signup sup=signupService.getUserById(Username);
			if(sup.getPassword().equals(Password)) {
				Signup login=signupService.getUserById(Username);
				model.addAttribute("login",login);
				return "home";
				
			}
			else {
				return "User/login";
			}
		}
		else {
			return "User/login";
		}
	}
	
	@GetMapping("/signup")
	public String addSignup(Model model) {
		
		Signup signup = new Signup();
		model.addAttribute("signup", signup);
		return "User/signup";
	}
	@PostMapping("/signup")
	public String addSignupProcess(@ModelAttribute("signup") Signup signup,@ModelAttribute("login") Login login,Model model) {
		if(signupService.usernameAlreadyExists(signup)==false) {
		try {
			signupService.addUser(signup);
			return "User/login";
		}
		catch(DataIntegrityViolationException e) {
			model.addAttribute("ErrorMessage","Email already exists" );
			return "User/signup";
		}
		}
		else {
//			model.addAttribute("ErrorMessage","Username already exists" );
			return "User/signup";
			
		}
	}
	

}
