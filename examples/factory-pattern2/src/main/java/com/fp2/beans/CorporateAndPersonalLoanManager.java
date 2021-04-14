package com.fp2.beans;

public class CorporateAndPersonalLoanManager implements LoanManager {
	private String occupation;
	private double grossAnnualIncome;
	private String organization;

	public CorporateAndPersonalLoanManager(String occupation, double grossAnnualIncome, String organization) {
		this.occupation = occupation;
		this.grossAnnualIncome = grossAnnualIncome;
		this.organization = organization;
	}

	public CorporateAndPersonalLoanManager(String occupation, double grossAnnualIncome) {
		this.occupation = occupation;
		this.grossAnnualIncome = grossAnnualIncome;
	}

	@Override
	public double applicableInterestRate(double principle, long tenure) {
		if (occupation.equals("salaried") && grossAnnualIncome > 1000000) {
			if (organization.equals("google")) {
				return 10.25;
			}
			return 14.45;
		}
		return 16.5;
	}
}
