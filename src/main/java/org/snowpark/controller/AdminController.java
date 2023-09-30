package org.snowpark.controller;

import java.util.List;

import org.snowpark.model.Admin;
import org.snowpark.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	//Add (correct code)
	@GetMapping("/addadmin")
	public String addAdmin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute("admin",admin);
		return "admin/addadmin";
	}
	
	@PostMapping("/addadmin")
	public String addAdminProcess(@ModelAttribute("admin")Admin admin) {
		if(adminService.usernameAlreadyExists(admin)==false) {
			if(adminService.mobileNumberAlreadyExists(admin)==false) {
				adminService.addAdmin(admin);
				return "/User/login";
			}
			else {
//				model.addAttribute("ErrorMessage","Email already exists" );
				return "/admin/addadmin";
			}
			}
			else {
//				model.addAttribute("ErrorMessage","Username already exists" );
				return "admin/addadmin";
				
			}
//		System.out.println("=====================================================");
//		System.out.println(admin);
//		System.out.println("=====================================================");
//		adminService.addAdmin(admin);
//		return "admin/addsuccess";
	}
	
//	Modify
	
	@GetMapping("/modifyadmin")
	public String modifyAdmin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute(admin);
		return "admin/modifyadmin";
	}
	
	@PostMapping("/fetchadmin")
	public String fetchAdmin(@ModelAttribute("admin") Admin admin,Model model)
	{
		 admin=adminService.findById(admin.getAdminId());
		if(admin!=null)
		{
			model.addAttribute("admin",admin);
			return "admin/fetchsuccess";
		}
		else
		{
			
			return "admin/fetchunsuccess";
		}
	}
	
	@PostMapping("/modifyadmin")
	public String processmodifyadmin(@ModelAttribute("admin") Admin admin)
	{
		Admin adm=adminService.updateAdmin(admin);
		if(adm!=null)
			return "admin/modifysuccess";
		else
			return "admin/modifyunsuccess";
	}
	
	
	//Delete
	
	@GetMapping("/deleteadmin")
	public String deleteAdmin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute(admin);
		return "admin/deleteadmin";
	}
	
	@PostMapping("/fetchdeleteadmin")
	public String fetchfordeleteadmin(@ModelAttribute("admin") Admin admin,Model model)
	{
	    admin=adminService.findById(admin.getAdminId());
		if(admin!=null)
		{
			model.addAttribute("admin",admin);
			return "admin/fetchdeletesuccess";
		}
		else
		{
			
			return "admin/fetchunsuccess";
		}
	}

	
	@PostMapping("/deleteadmin")
	public String processdeleteadmin(@ModelAttribute("admin") Admin admin)
	{
		Admin adm=adminService.deleteAdmin(admin.getAdminId());
		if(adm!=null)
			return "admin/deletesuccess";
		else
			return "admin/deleteunsuccess";
	}
	
	//Find by id
	
	
		@GetMapping("/findadmin")
		public String findadmin(Model model)
		{
			Admin admin=new Admin();
			model.addAttribute(admin);
			return "admin/findadmin";
		}
		
		@PostMapping("/fetchadmindetails")
		public String fetchadmindetails(@ModelAttribute("admin") Admin admin,Model model)
		{
			admin=adminService.findById(admin.getAdminId());
			if(admin!=null)
			{
				model.addAttribute("admin",admin);
				return "admin/findsuccess";
			}
			else
			{
				
				return "admin/fetchunsuccess";
			}
		}
		
		//validate customer
		
		@GetMapping("/login")
		public String loginadmin(Model model)
		{
			Admin admin=new Admin();
			model.addAttribute("admin",admin);
			return "AdminLogin/login"; 
			
		}
		
		@PostMapping("/validadmin")
		public String validadmin(@ModelAttribute("admin") Admin admin,Model model)
		{
			if(adminService.validateAdmin(admin.getUserName(),admin.getPassword())!=null)
				return "admin/profile"; //here add welcome $name then logged in
			else
				return "admin/profilenotfound";
		}
		
		
		
		
		@GetMapping("/findalladmins")
		public String listAdmins(Model model)
		{
			List<Admin> lists=adminService.findAll();
			model.addAttribute("lists",lists);
			if(lists.size()>0)
			return "admin/listadmins";
			else
				return "admin/fetchunsuccess";
		}

}