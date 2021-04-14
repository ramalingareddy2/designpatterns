package com.fp2.beans;

import java.util.Optional;

import com.fp2.pattern.LoanManagerFactory;

public class LoanEstimator {
	private LoanManager loanManager;

	public void estimateInterestAmountForHomeLoan(String propertyType, String city, double principleAmount,
			long tenure) {
		double applicableInterestRate = 0;
		double interestAmountToBePaid = 0;
		LoanManagerFactory loanManagerFactory = null;

		loanManagerFactory = new LoanManagerFactory();
		loanManagerFactory.setPropertyType(propertyType);
		loanManagerFactory.setCity(city);

		loanManager = loanManagerFactory.createLoanManager("home");
		applicableInterestRate = loanManager.applicableInterestRate(principleAmount, tenure);
		interestAmountToBePaid = (principleAmount * (tenure / 12) * applicableInterestRate) / 100.0;
		System.out.println("Interest Amount To Be Paid for home loan : " + interestAmountToBePaid);
	}

	public void estimateInterestAmountForPersonalLoan(String occupation, double grossAnnualIncome,
			double principleAmount, long tenure, String organization) {
		double applicableInterestRate = 0;
		double interestAmountToBePaid = 0;
		LoanManagerFactory loanManagerFactory = null;

		loanManagerFactory = new LoanManagerFactory();
		loanManagerFactory.setOccupation(occupation);
		loanManagerFactory.setGrossAnnualIncome(grossAnnualIncome);
		if (organization != null) {
			loanManagerFactory.setOrganization(organization);
		}

		loanManager = loanManagerFactory.createLoanManager("personal");
		applicableInterestRate = loanManager.applicableInterestRate(principleAmount, tenure);
		interestAmountToBePaid = (principleAmount * (tenure / 12) * applicableInterestRate) / 100.0;
		System.out.println("Interest Amount To Be Paid for personal loan : " + interestAmountToBePaid);
	}
}
