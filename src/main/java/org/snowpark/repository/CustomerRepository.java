package org.snowpark.repository;

import org.snowpark.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	boolean existsByUserName(String userName);
	boolean existsByMobileNumber(String mobileNumber);

}
