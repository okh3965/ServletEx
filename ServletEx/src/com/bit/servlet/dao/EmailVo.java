package com.bit.servlet.dao;

import java.sql.Date;

public class EmailVo {
	
	//field
	private Long no;	//PK
	private String lastName;
	private String firstName;
	private String email;
	private Date createdAt;
	
	//constructor
	//VO 객체에는 반드시 기본 생성자가 있어야 한다.
	public EmailVo() {
		
	}
	
	public EmailVo(String lastName,
					String firstName,
					String email) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}
	
	public EmailVo(String lastName,
					String firstName,
					String email,
					Date createdAt) {
		this(lastName, firstName, email);
		this.createdAt = createdAt;
	}
	
	public EmailVo(Long no, String lastName, 
					String firstName, 
					String email,
					Date createdAt) {
		this(lastName, firstName, email, createdAt);
		this.no = no;
	}

	
	// Getters/Setters
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "EmailVo [no=" + no + 
				", lastName=" + lastName + 
				", firstName=" + firstName + 
				", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}
	
	
}
