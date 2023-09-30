package org.snowpark.repository;
import org.snowpark.model.Signup;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//import com.Customer.model.Signup;
@Configuration
//import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

public interface SignupRepository extends JpaRepository<Signup,String>{

	boolean existsByUsername(String username);
//	Signup findByUsername(String Username);
//	Signup deleteByUsername(String Username);
}
