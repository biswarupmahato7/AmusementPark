package org.snowpark.repository;

import org.snowpark.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long>{
	boolean existsByUserName(String userName);
	boolean existsByMobileNumber(String mobileNumber);
	
}