package com.bajajpartner.dto;

import java.io.Serializable;

public class InsuranceApplication implements Serializable {
	private static final long serialVersionUID = 6127624965675976832L;
	private String memberName;
	private int age;
	private String gender;
	private int planNo;
	private int tenure;
	private double insurredAmount;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getInsurredAmount() {
		return insurredAmount;
	}

	public void setInsurredAmount(double insurredAmount) {
		this.insurredAmount = insurredAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
