package com.templatemethod.beans;

public class ApplyLoanDetails {
	private String loanType;
	private String crop;
	private String description;
	private Double amount;

	public ApplyLoanDetails() {
		super();
	}

	public ApplyLoanDetails(String loanType, String crop, String description, Double amount) {
		super();
		this.loanType = loanType;
		this.crop = crop;
		this.description = description;
		this.amount = amount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
