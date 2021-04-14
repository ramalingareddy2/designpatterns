package com.templatemethod.beans;

public class LoanApplication {
	private PersonalInfo personalInfo;
	private Identity identity;
	private BankAccount bankAccount;
	private ApplyLoanDetails applyLoanDetails;

	public LoanApplication() {
		super();
	}

	public LoanApplication(PersonalInfo personalInfo, Identity identity, BankAccount bankAccount,
			ApplyLoanDetails applyLoanDetails) {
		super();
		this.personalInfo = personalInfo;
		this.identity = identity;
		this.bankAccount = bankAccount;
		this.applyLoanDetails = applyLoanDetails;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public ApplyLoanDetails getApplyLoanDetails() {
		return applyLoanDetails;
	}

	public void setApplyLoanDetails(ApplyLoanDetails applyLoanDetails) {
		this.applyLoanDetails = applyLoanDetails;
	}

}
