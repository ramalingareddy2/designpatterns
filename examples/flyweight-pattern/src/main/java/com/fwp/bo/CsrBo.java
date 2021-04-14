package com.fwp.bo;

import java.io.Serializable;

public class CsrBo implements Serializable {
	private static final long serialVersionUID = -7336133197119571350L;
	private int csrNo;
	private String fullName;
	private String mobileNo;
	private int experience;
	private String designation;

	public int getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(int csrNo) {
		this.csrNo = csrNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
