package com.fp2.beans;

public class PersonalLoanManager implements LoanManager {
	private String occupation;
	private double grossAnnualIncome;

	public PersonalLoanManager(String occupation, double grossAnnualIncome) {
		this.occupation = occupation;
		this.grossAnnualIncome = grossAnnualIncome;
	}

	@Override
	public double applicableInterestRate(double principle, long tenure) {
		if (occupation.equals("salaried") && grossAnnualIncome > 1000000) {
			return 14.45;
		}
		return 16.5;
	}

}
