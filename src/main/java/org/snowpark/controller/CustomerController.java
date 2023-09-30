package org.snowpark.controller;

import java.util.List;

import org.snowpark.model.Customer;
import org.snowpark.repository.CustomerRepository;
import org.snowpark.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/addcustomer")
	public String addcustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "customer/addcustomer";
	}
	
	@PostMapping("/addcustomer")
	public String addCustomerProcess(@ModelAttribute("customer") Customer customer,Model model) {
		if(customerService.usernameAlreadyExists(customer)==false) {
			if(customerService.mobileNumberAlreadyExists(customer)==false) {
				customerService.addCustomer(customer);
				return "/User/login";
			}
			else {
//				model.addAttribute("ErrorMessage","Email already exists" );
				return "/customer/addcustomer";
			}
			}
			else {
//				model.addAttribute("ErrorMessage","Username already exists" );
				return "customer/addcustomer";
				
			}
		
//		System.out.println("=====================================================");
//		System.out.println(customer);
//		System.out.println("=====================================================");
//		customerService.addCustomer(customer);
//		return "/User/login";
	}
	
	@GetMapping("/modifycustomer")
	public String modifycustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "customer/modifycustomer";
	}
	
	@PostMapping("/fetchcustomer")
	public String fetchcustomer(@ModelAttribute("customer") Customer customer,Model model)
	{
		customer=customerService.findById(customer.getCustomerId());
		if(customer!=null)
		{
			model.addAttribute("customer",customer);
			return "customer/fetchsuccess";
		}
		else
		{
			
			return "customer/fetchunsuccess";
		}
	}
	
	@PostMapping("/modifycustomer")
	public String processmodifycustomer(@ModelAttribute("customer") Customer customer)
	{
		Customer cust=customerService.updateCustomer(customer);
		if(cust!=null)
			return "customer/modifysuccess";
		else
			return "customer/modifyunsuccess";
	}
	
	
	//Delete
	
	@GetMapping("/deletecustomer")
	public String deletecustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "customer/deletecustomer";
	}
	
	@PostMapping("/fetchdeletecustomer")
	public String fetchfordeleteadmin(@ModelAttribute("customer") Customer customer,Model model)
	{
		customer=customerService.findById(customer.getCustomerId());
		if(customer!=null)
		{
			model.addAttribute("customer",customer);
			return "customer/fetchdeletesuccess";
		}
		else
		{
			
			return "customer/fetchunsuccess";
		}
	}

	
	@PostMapping("/deletecustomer")
	public String processdeletecustomer(@ModelAttribute("customer")Customer customer)
	{
		Customer cust=customerService.deleteCustomer(customer.getCustomerId());
		if(cust!=null)
			return "customer/deletesuccess";
		else
			return "customer/deleteunsuccess";
	}
	
	
	//Find by id
	
	
	@GetMapping("/findcustomer")
	public String findcustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "customer/findcustomer";
	}
	
	@PostMapping("/fetchcustomerdetails")
	public String fetchcustomerdetails(@ModelAttribute("customer") Customer customer,Model model)
	{
		customer=customerService.findById(customer.getCustomerId());
		if(customer!=null)
		{
			model.addAttribute("customer",customer);
			return "customer/findsuccess";
		}
		else
		{
			
			return "customer/fetchunsuccess";
		}
	}
	
	//validate customer
	
	@GetMapping("/login")
	public String logincustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "User/login"; 
		
	}
	
	@PostMapping("/validcustomer")
	public String validcustomer(@ModelAttribute("customer") Customer customer,Model model)
	{
		if(customerService.validateCustomer(customer.getUserName(),customer.getPassword())!=null)
			return "customer/profile"; //here add welcome $name then logged in
		else
			return "customer/profilenotfound";
	}
	
	
	
	
	@GetMapping("/findallcustomers")
	public String listCustomers(Model model)
	{
		List<Customer> lists=customerService.findAll();
		model.addAttribute("lists",lists);
		if(lists.size()>0)
		return "customer/listcustomers";
		else
			return "customer/fetchunsuccess";
	}

}
