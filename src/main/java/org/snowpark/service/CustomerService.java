package org.snowpark.service;

import java.util.List;

import org.snowpark.model.Customer;
import org.springframework.stereotype.Service;

//import com.Customer.model.Signup;

@Service
public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Long customerId);

	public Customer findById(Long customerId);

	public List<Customer> findAll();
	
	public Customer validateCustomer(String username, String password);
	

	public boolean usernameAlreadyExists(Customer customer);
	
	public boolean mobileNumberAlreadyExists(Customer costomer);

//	public boolean existsByUsername(String userName);

//	public boolean existsByUsername(Customer customer);
}
