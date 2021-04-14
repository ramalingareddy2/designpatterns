package com.bajajpartner.dto;

import java.io.Serializable;
import java.util.Date;

public class Policy implements Serializable {
	private static final long serialVersionUID = -4873941116504499236L;
	private String policyNo;
	private String policyHolderName;
	private int planNo;
	private Date policyStartDate;
	private Date policyEndDate;
	private double insurredAmount;
	private double premiumAmount;

	public Policy() {
	}

	public Policy(String policyNo, String policyHolderName, int planNo, Date policyStartDate, Date policyEndDate,
			double insurredAmount, double premiumAmount) {
		super();
		this.policyNo = policyNo;
		this.policyHolderName = policyHolderName;
		this.planNo = planNo;
		this.policyStartDate = policyStartDate;
		this.policyEndDate = policyEndDate;
		this.insurredAmount = insurredAmount;
		this.premiumAmount = premiumAmount;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public Date getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public double getInsurredAmount() {
		return insurredAmount;
	}

	public void setInsurredAmount(double insurredAmount) {
		this.insurredAmount = insurredAmount;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
