package org.snowpark.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Component
@Scope("prototype")
@Table(name="customer")
public class Customer extends User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerid")
	private Long customerId;

	
	public Customer() {
		super();
	}

	public Customer(String userName, String password,String mobileNumber, String emailId) {
		super(userName, password,mobileNumber, emailId);
		// TODO Auto-generated constructor stub
	}


	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + "] | " + super.toString();
	}

}
