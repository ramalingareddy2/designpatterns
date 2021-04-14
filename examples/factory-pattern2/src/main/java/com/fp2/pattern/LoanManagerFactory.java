package com.fp2.pattern;

import com.fp2.beans.CorporateAndPersonalLoanManager;
import com.fp2.beans.HomeLoanManager;
import com.fp2.beans.LoanManager;

public class LoanManagerFactory {
	private String propertyType;
	private String city;
	private String occupation;
	private double grossAnnualIncome;
	private String organization;

	public LoanManager createLoanManager(String loanType) {
		LoanManager loanManager = null;

		if (loanType.equals("home")) {
			loanManager = new HomeLoanManager(propertyType, city);
		} else if (loanType.equals("personal")) {
			if (organization != null) {
				loanManager = new CorporateAndPersonalLoanManager(occupation, grossAnnualIncome, organization);
			} else {
				loanManager = new CorporateAndPersonalLoanManager(occupation, grossAnnualIncome);
			}
		}
		return loanManager;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public double getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(double grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

}
