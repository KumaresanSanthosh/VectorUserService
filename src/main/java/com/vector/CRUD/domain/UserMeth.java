package com.vector.CRUD.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;





@Entity
@Table(name="USER")
public class UserMeth {
	
	
	
	@Column(name="FIRST_NAME")
	@NotBlank(message = "The users first name")
	private String firstName;
	
	@Column(name="LAST_NAME")
	@NotBlank(message = "The users last name")
	private String lastName;
	
	@Id
	@Column(name="email",unique=true)
	@NotBlank(message = "The email of the user")
	private String emailAddress;
	
	@Column(name="password")
	@NotBlank(message = "The Password of the user")
	private String password;
	
	


	public UserMeth() {
		super();
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
