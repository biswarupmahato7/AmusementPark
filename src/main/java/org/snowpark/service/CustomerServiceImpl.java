package org.snowpark.service;

import java.util.List;
import java.util.Optional;

import org.snowpark.model.Customer;
import org.snowpark.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;



	@Override
	public boolean mobileNumberAlreadyExists(Customer costomer) {
		// TODO Auto-generated method stub
		return customerRepository.existsByMobileNumber(costomer.getMobileNumber());
	}

	@Override
	public boolean usernameAlreadyExists(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.existsByUserName(customer.getUserName());
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> opt = customerRepository.findById(customer.getCustomerId());
		if (opt.isPresent()) {
			customerRepository.save(customer);
			return customer;
		}

		return null;
	}

	@Override
	public Customer deleteCustomer(Long customerId) {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if (opt.isPresent()) {
			Customer customer = opt.get();
			customerRepository.delete(customer);
			return customer;
		}

		return null;
	}

	@Override
	public Customer findById(Long customerId) {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if (opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		}

		return null;
	}

	@Override
	public List<Customer> findAll() {

		return customerRepository.findAll();
	}

//	public boolean existsByUsername(Customer customer) {
//		// TODO Auto-generated method stub
//		
//		return customerRepository.existsByUsername(customer);
//	}

	@Override
	public Customer validateCustomer(String username, String password) {
		List<Customer> c1 = customerRepository.findAll();
		for (int i = 0; i < c1.size(); i++) {
			if (c1.get(i).getUserName().equals(username) && c1.get(i).getPassword().equals(password))
				return c1.get(i);
		}
		return null;
	}

}