package com.templatemethod.beans;

import java.util.Date;

public class PersonalInfo {
	private String fullName;
	private Date dob;
	private String gender;
	private String contactNo;
	private String emailAddress;

	public PersonalInfo() {
		super();
	}

	public PersonalInfo(String fullName, Date dob, String gender, String contactNo, String emailAddress) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.contactNo = contactNo;
		this.emailAddress = emailAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
