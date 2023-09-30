package org.snowpark.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
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
@Table(name="admin")
public class Admin extends User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adminid")
	private Long adminId;

	
	public Long getAdminId() {
		return adminId;
	}

	

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}



	public Admin( String userName, String password, String mobileNumber, String emailId) {
		super(userName, password, mobileNumber, emailId);
	}

	public Admin() {
		super();
	}
	
//
//	public Admin(Long adminId) {
//		super();
//		this.adminId = adminId;
//	}
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "] | " + super.toString();
	}
	
}